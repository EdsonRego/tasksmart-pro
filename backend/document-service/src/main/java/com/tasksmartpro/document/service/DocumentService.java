package com.tasksmartpro.document.service;

import com.tasksmartpro.document.dto.*;
import com.tasksmartpro.document.entity.DocumentMetadata;
import com.tasksmartpro.document.exception.NotFoundException;
import com.tasksmartpro.document.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repo;

    @Value("${storage.path}")
    private String storagePath;

    // ---------------- UPLOAD ----------------------------
    public UploadResponse upload(Long tenantId,
                                 Long referenceId,
                                 String referenceType,
                                 MultipartFile file) throws IOException {

        Path folder = Paths.get(storagePath);
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }

        String storedName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path target = folder.resolve(storedName);

        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        DocumentMetadata doc = DocumentMetadata.builder()
                .tenantId(tenantId)
                .referenceId(referenceId)
                .referenceType(referenceType)
                .originalName(file.getOriginalFilename())
                .storedName(storedName)
                .contentType(file.getContentType())
                .size(file.getSize())
                .build();

        DocumentMetadata saved = repo.save(doc);

        return UploadResponse.builder()
                .id(saved.getId())
                .fileName(saved.getOriginalName())
                .url("/documents/" + saved.getId() + "/download")
                .build();
    }

    // ---------------- LIST ----------------------------
    public List<DocumentResponse> listByReference(Long refId, String refType) {
        return repo.findByReferenceIdAndReferenceType(refId, refType)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ---------------- DOWNLOAD ----------------------------
    public byte[] download(Long id) throws IOException {
        DocumentMetadata doc = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Document not found: " + id));

        Path filePath = Paths.get(storagePath).resolve(doc.getStoredName());
        if (!Files.exists(filePath)) {
            throw new NotFoundException("File missing on disk: " + doc.getOriginalName());
        }

        return Files.readAllBytes(filePath);
    }

    // ---------------- DELETE ----------------------------
    public void delete(Long id) throws IOException {
        DocumentMetadata doc = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Document not found: " + id));

        Path filePath = Paths.get(storagePath).resolve(doc.getStoredName());
        Files.deleteIfExists(filePath);

        repo.delete(doc);
    }

    private DocumentResponse toResponse(DocumentMetadata m) {
        return DocumentResponse.builder()
                .id(m.getId())
                .tenantId(m.getTenantId())
                .referenceId(m.getReferenceId())
                .referenceType(m.getReferenceType())
                .originalName(m.getOriginalName())
                .storedName(m.getStoredName())
                .contentType(m.getContentType())
                .size(m.getSize())
                .uploadedAt(m.getUploadedAt())
                .build();
    }
}

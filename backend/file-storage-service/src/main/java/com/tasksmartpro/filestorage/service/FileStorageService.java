package com.tasksmartpro.filestorage.service;

import com.tasksmartpro.filestorage.dto.FileResponse;
import com.tasksmartpro.filestorage.entity.StoredFile;
import com.tasksmartpro.filestorage.exception.NotFoundException;
import com.tasksmartpro.filestorage.repository.StoredFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final StoredFileRepository repository;

    @Value("${file-storage.root-path}")
    private String rootPath;

    public FileResponse upload(MultipartFile file) throws IOException {

        Files.createDirectories(Paths.get(rootPath));

        String storedName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(rootPath, storedName);

        file.transferTo(path);

        StoredFile saved = repository.save(
                StoredFile.builder()
                        .originalName(file.getOriginalFilename())
                        .storedName(storedName)
                        .contentType(file.getContentType())
                        .size(file.getSize())
                        .path(path.toString())
                        .uploadDate(LocalDateTime.now())
                        .build()
        );

        return FileResponse.builder()
                .id(saved.getId())
                .fileName(saved.getOriginalName())
                .url("/files/download/" + saved.getId())
                .size(saved.getSize())
                .build();
    }

    public byte[] download(Long id) throws IOException {
        StoredFile file = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Arquivo não encontrado"));

        return Files.readAllBytes(Path.of(file.getPath()));
    }

    public void delete(Long id) throws IOException {
        StoredFile file = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Arquivo não encontrado"));

        Files.deleteIfExists(Path.of(file.getPath()));
        repository.delete(file);
    }
}

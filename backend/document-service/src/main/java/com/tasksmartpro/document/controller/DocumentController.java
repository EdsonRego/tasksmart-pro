package com.tasksmartpro.document.controller;

import com.tasksmartpro.document.dto.DocumentResponse;
import com.tasksmartpro.document.dto.UploadResponse;
import com.tasksmartpro.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService service;

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> upload(
            @RequestParam Long tenantId,
            @RequestParam Long referenceId,
            @RequestParam String referenceType,
            @RequestParam MultipartFile file) throws IOException {

        return ResponseEntity.ok(service.upload(tenantId, referenceId, referenceType, file));
    }

    @GetMapping("/reference")
    public ResponseEntity<List<DocumentResponse>> listByReference(
            @RequestParam Long referenceId,
            @RequestParam String referenceType) {
        return ResponseEntity.ok(service.listByReference(referenceId, referenceType));
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> download(@PathVariable Long id) throws IOException {

        byte[] data = service.download(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document")
                .body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws IOException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

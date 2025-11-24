package com.tasksmartpro.document.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class DocumentResponse {
    private Long id;
    private Long tenantId;
    private Long referenceId;
    private String referenceType;
    private String originalName;
    private String storedName;
    private String contentType;
    private Long size;
    private LocalDateTime uploadedAt;
}

package com.tasksmartpro.document.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class DocumentMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    private Long referenceId; // asset, workorder, checklist, etc.

    private String referenceType; // ASSET, WORKORDER, CHECKLIST, PLAN, METER

    private String originalName;

    private String storedName;

    private String contentType;

    private Long size;

    private LocalDateTime uploadedAt;

    @PrePersist
    public void prePersist() {
        uploadedAt = LocalDateTime.now();
    }
}

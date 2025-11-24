package com.tasksmartpro.document.repository;

import com.tasksmartpro.document.entity.DocumentMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<DocumentMetadata, Long> {
    List<DocumentMetadata> findByReferenceIdAndReferenceType(Long referenceId, String referenceType);
    List<DocumentMetadata> findByTenantId(Long tenantId);
}

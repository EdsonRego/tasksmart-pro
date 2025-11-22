package com.tasksmartpro.checklist.repository;

import com.tasksmartpro.checklist.entity.ChecklistTemplateDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChecklistTemplateRepository extends MongoRepository<ChecklistTemplateDocument, String> {
    List<ChecklistTemplateDocument> findByTenantId(Long tenantId);
}

package com.tasksmartpro.checklist.repository;

import com.tasksmartpro.checklist.entity.ChecklistDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChecklistRepository extends MongoRepository<ChecklistDocument, String> {
    List<ChecklistDocument> findByTenantId(Long tenantId);
}

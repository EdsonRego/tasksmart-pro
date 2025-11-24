package com.tasksmartpro.auditlog.repository;

import com.tasksmartpro.auditlog.entity.AuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {

    List<AuditLog> findByTenantId(Long tenantId);

    List<AuditLog> findByUserId(Long userId);

    List<AuditLog> findByAction(String action);

    List<AuditLog> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}

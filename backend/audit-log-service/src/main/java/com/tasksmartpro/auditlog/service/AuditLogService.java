package com.tasksmartpro.auditlog.service;

import com.tasksmartpro.auditlog.dto.*;
import com.tasksmartpro.auditlog.entity.AuditLog;
import com.tasksmartpro.auditlog.exception.NotFoundException;
import com.tasksmartpro.auditlog.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository repo;

    public AuditLogResponse create(CreateAuditLogRequest req) {

        AuditLog log = AuditLog.builder()
                .tenantId(req.getTenantId())
                .userId(req.getUserId())
                .action(req.getAction())
                .serviceName(req.getServiceName())
                .resource(req.getResource())
                .resourceId(req.getResourceId())
                .details(req.getDetails())
                .timestamp(LocalDateTime.now())
                .build();

        repo.save(log);

        return toResponse(log);
    }

    public AuditLogResponse get(String id) {
        AuditLog log = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Audit log not found: " + id));

        return toResponse(log);
    }

    public List<AuditLog> listByTenant(Long tenantId) {
        return repo.findByTenantId(tenantId);
    }

    public List<AuditLog> listByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<AuditLog> listByPeriod(LocalDateTime start, LocalDateTime end) {
        return repo.findByTimestampBetween(start, end);
    }

    private AuditLogResponse toResponse(AuditLog log) {
        return AuditLogResponse.builder()
                .id(log.getId())
                .tenantId(log.getTenantId())
                .userId(log.getUserId())
                .action(log.getAction())
                .serviceName(log.getServiceName())
                .resource(log.getResource())
                .resourceId(log.getResourceId())
                .details(log.getDetails())
                .timestamp(log.getTimestamp())
                .build();
    }
}

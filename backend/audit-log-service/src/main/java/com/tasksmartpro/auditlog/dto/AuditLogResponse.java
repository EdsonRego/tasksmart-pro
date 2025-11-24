package com.tasksmartpro.auditlog.dto;

import com.tasksmartpro.auditlog.enums.AuditAction;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AuditLogResponse {

    private String id;

    private Long tenantId;
    private Long userId;

    private AuditAction action;

    private String serviceName;
    private String resource;
    private String resourceId;

    private String details;

    private LocalDateTime timestamp;
}

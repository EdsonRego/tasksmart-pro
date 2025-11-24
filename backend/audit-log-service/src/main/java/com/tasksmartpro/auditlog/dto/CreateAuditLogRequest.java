package com.tasksmartpro.auditlog.dto;

import com.tasksmartpro.auditlog.enums.AuditAction;
import lombok.Data;

@Data
public class CreateAuditLogRequest {

    private Long tenantId;
    private Long userId;

    private AuditAction action;

    private String serviceName;
    private String resource;
    private String resourceId;
    private String details;
}

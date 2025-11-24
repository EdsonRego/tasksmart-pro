package com.tasksmartpro.auditlog.entity;

import com.tasksmartpro.auditlog.enums.AuditAction;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "audit_logs")
public class AuditLog {

    @Id
    private String id;

    private Long tenantId;
    private Long userId;

    private AuditAction action;

    private String serviceName; // ex: workorder-service
    private String resource;    // ex: "WorkOrder"
    private String resourceId;  // ex: "123"
    private String details;

    private LocalDateTime timestamp;
}

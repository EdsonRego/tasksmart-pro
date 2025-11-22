package com.tasksmartpro.notification.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EventNotificationRequest {
    private Long tenantId;
    private String eventType;
    private String payload; // JSON vindo do WorkOrder-Service
}

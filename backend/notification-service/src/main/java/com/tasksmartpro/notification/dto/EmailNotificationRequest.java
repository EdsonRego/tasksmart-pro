package com.tasksmartpro.notification.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmailNotificationRequest {
    private Long tenantId;
    private String to;
    private String subject;
    private String message;
}

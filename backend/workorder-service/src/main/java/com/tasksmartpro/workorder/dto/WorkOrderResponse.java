package com.tasksmartpro.workorder.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WorkOrderResponse {
    private Long id;
    private Long tenantId;
    private String title;
    private String description;
    private String checklistId;
    private String assignedUserEmail;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


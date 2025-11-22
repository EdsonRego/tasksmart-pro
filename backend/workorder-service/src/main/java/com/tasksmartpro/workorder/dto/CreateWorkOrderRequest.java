package com.tasksmartpro.workorder.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateWorkOrderRequest {
    private Long tenantId;
    private String title;
    private String description;
    private String checklistId;  // id do checklist preenchido
    private String assignedUserEmail;
}

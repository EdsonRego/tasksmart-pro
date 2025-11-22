package com.tasksmartpro.workorder.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UpdateWorkOrderRequest {
    private String title;
    private String description;
    private String assignedUserEmail;
    private String status;
}

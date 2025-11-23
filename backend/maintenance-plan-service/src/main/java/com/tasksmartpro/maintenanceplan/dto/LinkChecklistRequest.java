package com.tasksmartpro.maintenanceplan.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LinkChecklistRequest {

    private Long tenantId;
    private Long planId;
    private String checklistId;
}

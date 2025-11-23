package com.tasksmartpro.maintenanceplan.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateMaintenancePlanRequest {
    private Long tenantId;
    private String name;
    private String description;
}

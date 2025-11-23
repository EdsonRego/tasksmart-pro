package com.tasksmartpro.maintenanceplan.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateScheduleRuleRequest {

    private Long tenantId;
    private Long planId;
    private String periodicity; // DAILY, WEEKLY...
    private Integer frequency;
}

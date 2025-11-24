package com.tasksmartpro.report.dto.workorder;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WorkOrderDto {
    private Long id;
    private Long assetId;
    private String status;
    private String description;
}

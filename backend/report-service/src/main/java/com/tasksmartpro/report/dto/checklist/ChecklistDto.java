package com.tasksmartpro.report.dto.checklist;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChecklistDto {
    private String id;
    private String title;
    private Long tenantId;
}

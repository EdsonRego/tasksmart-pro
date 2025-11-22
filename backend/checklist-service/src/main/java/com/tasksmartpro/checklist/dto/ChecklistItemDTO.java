package com.tasksmartpro.checklist.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChecklistItemDTO {
    private String description;
    private String status;
}

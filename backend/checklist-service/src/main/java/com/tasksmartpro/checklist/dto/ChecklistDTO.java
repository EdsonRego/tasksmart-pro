package com.tasksmartpro.checklist.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChecklistDTO {
    private String id;
    private Long tenantId;
    private String name;
    private List<ChecklistItemDTO> items;
}


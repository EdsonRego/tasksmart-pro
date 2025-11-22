package com.tasksmartpro.checklist.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UpdateChecklistRequest {
    private String name;
    private List<ChecklistItemDTO> items;
}

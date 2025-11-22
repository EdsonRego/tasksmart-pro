package com.tasksmartpro.checklist.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateTemplateRequest {
    private Long tenantId;
    private String name;
    private List<String> itemDescriptions;
}

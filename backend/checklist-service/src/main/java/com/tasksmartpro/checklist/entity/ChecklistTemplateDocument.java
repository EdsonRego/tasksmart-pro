package com.tasksmartpro.checklist.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "checklist_templates")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChecklistTemplateDocument {

    @Id
    private String id;

    private Long tenantId;
    private String name;

    private List<String> itemDescriptions;
}

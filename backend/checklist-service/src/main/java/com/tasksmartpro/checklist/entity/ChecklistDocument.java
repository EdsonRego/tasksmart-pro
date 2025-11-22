package com.tasksmartpro.checklist.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "checklists")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChecklistDocument {

    @Id
    private String id;

    private Long tenantId;
    private String name;

    private List<ChecklistItem> items;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class ChecklistItem {
        private String description;
        private String status; // PENDING, OK, NOK
    }
}

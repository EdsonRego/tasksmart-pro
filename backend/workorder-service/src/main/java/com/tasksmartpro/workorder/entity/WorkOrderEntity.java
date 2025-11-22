package com.tasksmartpro.workorder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "work_orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WorkOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;               // multi-tenancy

    private String title;
    private String description;

    private String checklistId;          // ID retornado pelo Mongo (futuro snapshot)

    @Enumerated(EnumType.STRING)
    private WorkOrderStatus status;

    private String assignedUserEmail;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

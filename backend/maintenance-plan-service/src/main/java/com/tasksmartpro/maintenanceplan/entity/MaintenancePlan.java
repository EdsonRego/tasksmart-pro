package com.tasksmartpro.maintenanceplan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_plans")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MaintenancePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    @Column(nullable = false)
    private String name;

    private String description;

    private Boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

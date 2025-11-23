package com.tasksmartpro.maintenanceplan.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plan_checklist_link")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PlanChecklistLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MaintenancePlan plan;

    private String checklistId; // ID MongoDB
}

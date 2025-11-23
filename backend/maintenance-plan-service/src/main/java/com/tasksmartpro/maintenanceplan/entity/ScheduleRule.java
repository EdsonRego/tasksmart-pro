package com.tasksmartpro.maintenanceplan.entity;

import com.tasksmartpro.maintenanceplan.enums.Periodicity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedule_rules")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ScheduleRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MaintenancePlan plan;

    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    private Integer frequency;

    private LocalDateTime nextExecution;
}

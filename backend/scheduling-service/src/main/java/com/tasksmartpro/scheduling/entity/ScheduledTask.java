package com.tasksmartpro.scheduling.entity;

import com.tasksmartpro.scheduling.enums.TaskStatus;
import com.tasksmartpro.scheduling.enums.TaskType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheduled_tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduledTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;
    private Long assetId;
    private Long maintenancePlanId;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private String cronExpression;     // Para tasks CRON
    private LocalDateTime nextRunAt;   // Para tasks TIME_BASED

    private boolean active;

    private LocalDateTime createdAt;
}

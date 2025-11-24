package com.tasksmartpro.scheduling.dto;

import com.tasksmartpro.scheduling.enums.TaskStatus;
import com.tasksmartpro.scheduling.enums.TaskType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ScheduledTaskResponse {

    private Long id;
    private Long tenantId;
    private Long assetId;
    private Long maintenancePlanId;
    private TaskType type;
    private TaskStatus status;
    private boolean active;
    private String cronExpression;
    private LocalDateTime nextRunAt;
}

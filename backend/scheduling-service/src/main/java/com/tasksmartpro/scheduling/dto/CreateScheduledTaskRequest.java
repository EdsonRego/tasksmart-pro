package com.tasksmartpro.scheduling.dto;

import com.tasksmartpro.scheduling.enums.TaskType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateScheduledTaskRequest {

    @NotNull
    private Long tenantId;

    @NotNull
    private Long maintenancePlanId;

    private Long assetId;

    @NotNull
    private TaskType type;

    private String cronExpression;
}

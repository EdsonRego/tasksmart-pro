package com.tasksmartpro.scheduling.dto;

import lombok.Data;

@Data
public class UpdateScheduledTaskRequest {
    private boolean active;
    private String cronExpression;
}

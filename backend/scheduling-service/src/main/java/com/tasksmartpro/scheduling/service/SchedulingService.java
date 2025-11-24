package com.tasksmartpro.scheduling.service;

import com.tasksmartpro.scheduling.dto.*;
import com.tasksmartpro.scheduling.entity.*;
import com.tasksmartpro.scheduling.enums.*;
import com.tasksmartpro.scheduling.exception.NotFoundException;
import com.tasksmartpro.scheduling.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final ScheduledTaskRepository taskRepo;
    private final ExecutionHistoryRepository historyRepo;

    public ScheduledTaskResponse create(CreateScheduledTaskRequest req) {

        ScheduledTask task = ScheduledTask.builder()
                .tenantId(req.getTenantId())
                .maintenancePlanId(req.getMaintenancePlanId())
                .assetId(req.getAssetId())
                .type(req.getType())
                .status(TaskStatus.PENDING)
                .active(true)
                .cronExpression(req.getCronExpression())
                .createdAt(LocalDateTime.now())
                .nextRunAt(LocalDateTime.now().plusMinutes(1))
                .build();

        taskRepo.save(task);

        return toResponse(task);
    }

    public List<ScheduledTask> findAll() {
        return taskRepo.findAll();
    }

    public ScheduledTaskResponse getById(Long id) {
        ScheduledTask task = taskRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("ScheduledTask not found: " + id));

        return toResponse(task);
    }

    private ScheduledTaskResponse toResponse(ScheduledTask t) {
        return ScheduledTaskResponse.builder()
                .id(t.getId())
                .tenantId(t.getTenantId())
                .assetId(t.getAssetId())
                .maintenancePlanId(t.getMaintenancePlanId())
                .type(t.getType())
                .status(t.getStatus())
                .cronExpression(t.getCronExpression())
                .active(t.isActive())
                .nextRunAt(t.getNextRunAt())
                .build();
    }
}

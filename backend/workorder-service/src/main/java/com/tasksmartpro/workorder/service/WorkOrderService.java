package com.tasksmartpro.workorder.service;

import com.tasksmartpro.workorder.dto.*;
import com.tasksmartpro.workorder.entity.*;
import com.tasksmartpro.workorder.repository.EventLogRepository;
import com.tasksmartpro.workorder.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WorkOrderService {

    private final WorkOrderRepository repository;
    private final EventLogRepository eventLogRepository;

    public WorkOrderResponse create(CreateWorkOrderRequest request) {

        WorkOrderEntity entity = WorkOrderEntity.builder()
                .tenantId(request.getTenantId())
                .title(request.getTitle())
                .description(request.getDescription())
                .checklistId(request.getChecklistId())
                .assignedUserEmail(request.getAssignedUserEmail())
                .status(WorkOrderStatus.OPEN)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        WorkOrderEntity saved = repository.save(entity);

        logEvent(saved.getId(), "WorkOrder created");

        return toResponse(saved);
    }

    public WorkOrderResponse update(Long id, UpdateWorkOrderRequest request) {

        WorkOrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkOrder not found"));

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setAssignedUserEmail(request.getAssignedUserEmail());
        entity.setStatus(WorkOrderStatus.valueOf(request.getStatus()));
        entity.setUpdatedAt(LocalDateTime.now());

        WorkOrderEntity saved = repository.save(entity);

        logEvent(saved.getId(), "WorkOrder updated: " + request.getStatus());

        return toResponse(saved);
    }

    public WorkOrderResponse findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("WorkOrder not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
        logEvent(id, "WorkOrder deleted");
    }

    private void logEvent(Long workOrderId, String msg) {
        eventLogRepository.save(EventLogEntity.builder()
                .workOrderId(workOrderId)
                .message(msg)
                .timestamp(LocalDateTime.now())
                .build());
    }

    private WorkOrderResponse toResponse(WorkOrderEntity entity) {
        return WorkOrderResponse.builder()
                .id(entity.getId())
                .tenantId(entity.getTenantId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .checklistId(entity.getChecklistId())
                .assignedUserEmail(entity.getAssignedUserEmail())
                .status(entity.getStatus().name())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}

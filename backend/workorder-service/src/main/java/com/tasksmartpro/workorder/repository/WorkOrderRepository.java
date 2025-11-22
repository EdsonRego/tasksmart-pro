package com.tasksmartpro.workorder.repository;

import com.tasksmartpro.workorder.entity.WorkOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrderEntity, Long> {
    List<WorkOrderEntity> findByTenantId(Long tenantId);
}

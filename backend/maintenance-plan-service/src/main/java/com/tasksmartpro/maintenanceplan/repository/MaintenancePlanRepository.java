package com.tasksmartpro.maintenanceplan.repository;

import com.tasksmartpro.maintenanceplan.entity.MaintenancePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan, Long> {
    List<MaintenancePlan> findByTenantId(Long tenantId);
}

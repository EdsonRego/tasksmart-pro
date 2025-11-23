package com.tasksmartpro.maintenanceplan.repository;

import com.tasksmartpro.maintenanceplan.entity.ScheduleRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRuleRepository extends JpaRepository<ScheduleRule, Long> {
    List<ScheduleRule> findByTenantId(Long tenantId);
}

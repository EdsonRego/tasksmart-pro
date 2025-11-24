package com.tasksmartpro.meterreading.repository;

import com.tasksmartpro.meterreading.entity.MeterRuleExecutionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterRuleHistoryRepository extends JpaRepository<MeterRuleExecutionHistory, Long> {
    List<MeterRuleExecutionHistory> findByTenantId(Long tenantId);
}

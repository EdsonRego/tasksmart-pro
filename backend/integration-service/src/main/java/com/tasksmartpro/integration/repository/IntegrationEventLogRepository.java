package com.tasksmartpro.integration.repository;

import com.tasksmartpro.integration.entity.IntegrationEventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrationEventLogRepository extends JpaRepository<IntegrationEventLog, Long> {
}

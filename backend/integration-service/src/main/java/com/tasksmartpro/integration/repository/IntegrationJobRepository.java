package com.tasksmartpro.integration.repository;

import com.tasksmartpro.integration.entity.IntegrationJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrationJobRepository extends JpaRepository<IntegrationJob, Long> {
}

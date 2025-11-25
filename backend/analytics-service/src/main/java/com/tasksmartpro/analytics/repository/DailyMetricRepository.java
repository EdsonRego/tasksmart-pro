package com.tasksmartpro.analytics.repository;

import com.tasksmartpro.analytics.entity.DailyMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyMetricRepository extends JpaRepository<DailyMetric, Long> {
}

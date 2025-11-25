package com.tasksmartpro.analytics.repository;

import com.tasksmartpro.analytics.entity.AnalyticsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticsRecordRepository extends JpaRepository<AnalyticsRecord, Long> {
}

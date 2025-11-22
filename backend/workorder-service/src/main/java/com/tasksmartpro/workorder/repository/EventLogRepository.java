package com.tasksmartpro.workorder.repository;

import com.tasksmartpro.workorder.entity.EventLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventLogRepository extends JpaRepository<EventLogEntity, Long> {
    List<EventLogEntity> findByWorkOrderId(Long workOrderId);
}

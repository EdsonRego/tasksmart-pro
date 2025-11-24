package com.tasksmartpro.scheduling.repository;

import com.tasksmartpro.scheduling.entity.ExecutionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExecutionHistoryRepository extends JpaRepository<ExecutionHistory, Long> {

    List<ExecutionHistory> findByScheduledTaskId(Long taskId);
}

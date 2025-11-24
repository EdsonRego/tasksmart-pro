package com.tasksmartpro.scheduling.repository;

import com.tasksmartpro.scheduling.entity.ScheduledTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduledTaskRepository extends JpaRepository<ScheduledTask, Long> {

    List<ScheduledTask> findByActiveTrue();
}

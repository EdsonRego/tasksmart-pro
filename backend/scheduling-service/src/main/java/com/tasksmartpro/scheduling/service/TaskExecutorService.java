package com.tasksmartpro.scheduling.service;

import com.tasksmartpro.scheduling.entity.*;
import com.tasksmartpro.scheduling.enums.TaskStatus;
import com.tasksmartpro.scheduling.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskExecutorService {

    private final ScheduledTaskRepository taskRepo;
    private final ExecutionHistoryRepository historyRepo;

    @Scheduled(fixedDelay = 60000)
    public void processTasks() {

        List<ScheduledTask> tasks = taskRepo.findByActiveTrue();

        for (ScheduledTask task : tasks) {

            if (task.getNextRunAt().isAfter(LocalDateTime.now())) {
                continue;
            }

            log.info("Executing task {}", task.getId());

            // Registrar histórico
            ExecutionHistory hist = ExecutionHistory.builder()
                    .scheduledTaskId(task.getId())
                    .status(TaskStatus.RUNNING)
                    .executedAt(LocalDateTime.now())
                    .message("Task executed successfully")
                    .build();

            historyRepo.save(hist);

            // Marcar próximo horário
            task.setNextRunAt(LocalDateTime.now().plusMinutes(1));
            taskRepo.save(task);
        }
    }
}

package com.tasksmartpro.scheduling.controller;

import com.tasksmartpro.scheduling.dto.*;
import com.tasksmartpro.scheduling.entity.ExecutionHistory;
import com.tasksmartpro.scheduling.service.SchedulingService;
import com.tasksmartpro.scheduling.repository.ExecutionHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduling")
@RequiredArgsConstructor
public class SchedulingController {

    private final SchedulingService service;
    private final ExecutionHistoryRepository historyRepo;

    @PostMapping
    public ResponseEntity<ScheduledTaskResponse> create(@RequestBody CreateScheduledTaskRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduledTaskResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<ExecutionHistory>> getHistory(@PathVariable Long id) {
        return ResponseEntity.ok(historyRepo.findByScheduledTaskId(id));
    }
}

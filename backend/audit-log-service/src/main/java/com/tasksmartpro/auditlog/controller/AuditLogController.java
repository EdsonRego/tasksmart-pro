package com.tasksmartpro.auditlog.controller;

import com.tasksmartpro.auditlog.dto.*;
import com.tasksmartpro.auditlog.entity.AuditLog;
import com.tasksmartpro.auditlog.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/audit")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogService service;

    @PostMapping
    public ResponseEntity<AuditLogResponse> create(@RequestBody CreateAuditLogRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<AuditLog>> getByTenant(@PathVariable Long tenantId) {
        return ResponseEntity.ok(service.listByTenant(tenantId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLog>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.listByUser(userId));
    }

    @GetMapping("/period")
    public ResponseEntity<List<AuditLog>> getByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return ResponseEntity.ok(service.listByPeriod(start, end));
    }
}

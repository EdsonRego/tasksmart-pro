package com.tasksmartpro.analytics.controller;

import com.tasksmartpro.analytics.dto.DashboardSummaryResponse;
import com.tasksmartpro.analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService service;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardSummaryResponse> getDashboardMetrics() {
        return ResponseEntity.ok(service.generateDashboardSummary());
    }
}

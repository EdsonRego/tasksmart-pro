package com.tasksmartpro.maintenanceplan.controller;

import com.tasksmartpro.maintenanceplan.dto.*;
import com.tasksmartpro.maintenanceplan.entity.*;
import com.tasksmartpro.maintenanceplan.service.MaintenancePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintenance-plans")
@RequiredArgsConstructor
public class MaintenancePlanController {

    private final MaintenancePlanService service;

    @PostMapping
    public ResponseEntity<MaintenancePlan> create(@RequestBody CreateMaintenancePlanRequest req) {
        return ResponseEntity.ok(service.createPlan(req));
    }

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleRule> addSchedule(@RequestBody CreateScheduleRuleRequest req) {
        return ResponseEntity.ok(service.createScheduleRule(req));
    }

    @PostMapping("/link-asset")
    public ResponseEntity<PlanAssetLink> linkAsset(@RequestBody LinkAssetRequest req) {
        return ResponseEntity.ok(service.linkAsset(req));
    }

    @PostMapping("/link-checklist")
    public ResponseEntity<PlanChecklistLink> linkChecklist(@RequestBody LinkChecklistRequest req) {
        return ResponseEntity.ok(service.linkChecklist(req));
    }
}

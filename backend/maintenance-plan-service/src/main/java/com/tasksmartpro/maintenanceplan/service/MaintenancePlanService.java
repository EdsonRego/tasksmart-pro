package com.tasksmartpro.maintenanceplan.service;

import com.tasksmartpro.maintenanceplan.dto.*;
import com.tasksmartpro.maintenanceplan.entity.*;
import com.tasksmartpro.maintenanceplan.enums.Periodicity;
import com.tasksmartpro.maintenanceplan.exception.NotFoundException;
import com.tasksmartpro.maintenanceplan.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MaintenancePlanService {

    private final MaintenancePlanRepository planRepo;
    private final ScheduleRuleRepository ruleRepo;
    private final PlanAssetLinkRepository assetLinkRepo;
    private final PlanChecklistLinkRepository checklistLinkRepo;

    public MaintenancePlan createPlan(CreateMaintenancePlanRequest req) {
        MaintenancePlan plan = MaintenancePlan.builder()
                .tenantId(req.getTenantId())
                .name(req.getName())
                .description(req.getDescription())
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return planRepo.save(plan);
    }

    public ScheduleRule createScheduleRule(CreateScheduleRuleRequest req) {
        MaintenancePlan plan = planRepo.findById(req.getPlanId())
                .orElseThrow(() -> new NotFoundException("Plan not found"));

        ScheduleRule rule = ScheduleRule.builder()
                .tenantId(req.getTenantId())
                .plan(plan)
                .periodicity(Periodicity.valueOf(req.getPeriodicity()))
                .frequency(req.getFrequency())
                .nextExecution(LocalDateTime.now().plusDays(1))
                .build();

        return ruleRepo.save(rule);
    }

    public PlanAssetLink linkAsset(LinkAssetRequest req) {
        MaintenancePlan plan = planRepo.findById(req.getPlanId())
                .orElseThrow(() -> new NotFoundException("Plan not found"));

        return assetLinkRepo.save(
                PlanAssetLink.builder()
                        .tenantId(req.getTenantId())
                        .plan(plan)
                        .assetId(req.getAssetId())
                        .build()
        );
    }

    public PlanChecklistLink linkChecklist(LinkChecklistRequest req) {
        MaintenancePlan plan = planRepo.findById(req.getPlanId())
                .orElseThrow(() -> new NotFoundException("Plan not found"));

        return checklistLinkRepo.save(
                PlanChecklistLink.builder()
                        .tenantId(req.getTenantId())
                        .plan(plan)
                        .checklistId(req.getChecklistId())
                        .build()
        );
    }
}

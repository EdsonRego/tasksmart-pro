package com.tasksmartpro.analytics.service;

import com.tasksmartpro.analytics.dto.DashboardSummaryResponse;
import com.tasksmartpro.analytics.entity.AnalyticsRecord;
import com.tasksmartpro.analytics.repository.AnalyticsRecordRepository;
import com.tasksmartpro.analytics.feign.WorkOrderClient;
import com.tasksmartpro.analytics.feign.ChecklistClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Supplier; // <- IMPORT CORRETO

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final AnalyticsRecordRepository recordRepository;
    private final WorkOrderClient workOrderClient;
    private final ChecklistClient checklistClient;

    public DashboardSummaryResponse generateDashboardSummary() {

        int open = safeCall(() -> workOrderClient.countOpen());
        int overdue = safeCall(() -> workOrderClient.countOverdue());
        int completed = safeCall(() -> workOrderClient.countCompleted());
        int pendingChecklists = safeCall(() -> checklistClient.countPending());

        recordRepository.save(
                AnalyticsRecord.builder()
                        .metricName("dashboard_update")
                        .metricValue(1.0)
                        .date(LocalDate.now())
                        .build()
        );

        return DashboardSummaryResponse.builder()
                .openWorkOrders(open)
                .overdueWorkOrders(overdue)
                .completedWorkOrders(completed)
                .pendingChecklists(pendingChecklists)
                .build();
    }

    private Integer safeCall(Supplier<Integer> call) {
        try {
            return call.get();
        } catch (Exception e) {
            return 0;
        }
    }
}

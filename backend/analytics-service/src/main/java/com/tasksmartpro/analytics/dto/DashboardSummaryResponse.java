package com.tasksmartpro.analytics.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardSummaryResponse {

    private int openWorkOrders;
    private int overdueWorkOrders;
    private int completedWorkOrders;

    private int pendingChecklists;
}

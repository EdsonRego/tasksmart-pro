package com.tasksmartpro.analytics.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_metrics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate day;

    private Integer openWorkOrders;
    private Integer overdueWorkOrders;
    private Integer completedWorkOrders;

    private Integer pendingChecklists;
}

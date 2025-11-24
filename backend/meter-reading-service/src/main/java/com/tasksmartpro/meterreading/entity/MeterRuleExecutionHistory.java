package com.tasksmartpro.meterreading.entity;

import com.tasksmartpro.meterreading.enums.MeterRuleStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meter_rule_history")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MeterRuleExecutionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assetId;

    private Long tenantId;

    private Long ruleId; // future link to maintenance-plan-service

    private Double readingValue;

    @Enumerated(EnumType.STRING)
    private MeterRuleStatus status;

    private String notes;

    private LocalDateTime executedAt;

    @PrePersist
    public void beforePersist() {
        this.executedAt = LocalDateTime.now();
    }
}


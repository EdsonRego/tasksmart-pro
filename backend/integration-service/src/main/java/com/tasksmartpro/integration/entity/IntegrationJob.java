package com.tasksmartpro.integration.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "integration_jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntegrationJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalSystem; // ERP, SAP, Totvs, Webhook source
    private String endpoint;       // URL de destino
    private String status;         // PENDING, SUCCESS, FAILED

    @Column(columnDefinition = "TEXT")
    private String payload;

    private LocalDateTime createdAt;
    private LocalDateTime executedAt;
}

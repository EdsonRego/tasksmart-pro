package com.tasksmartpro.integration.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "integration_event_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntegrationEventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType; // WEBHOOK_RECEIVED, SYNC_SENT, SYNC_RECEIVED

    @Column(columnDefinition = "TEXT")
    private String data;

    private LocalDateTime createdAt;
}

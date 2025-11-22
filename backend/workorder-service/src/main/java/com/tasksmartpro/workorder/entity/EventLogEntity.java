package com.tasksmartpro.workorder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "workorder_events")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EventLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long workOrderId;

    private String message;

    private LocalDateTime timestamp;
}

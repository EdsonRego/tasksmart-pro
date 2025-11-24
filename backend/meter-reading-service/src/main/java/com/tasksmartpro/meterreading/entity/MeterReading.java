package com.tasksmartpro.meterreading.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meter_readings")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assetId;

    private Long tenantId;

    private Double value; // horas, km, ciclos

    private LocalDateTime readingDate;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.readingDate == null) {
            this.readingDate = LocalDateTime.now();
        }
    }
}

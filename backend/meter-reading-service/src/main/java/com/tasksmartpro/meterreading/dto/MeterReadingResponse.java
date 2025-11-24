package com.tasksmartpro.meterreading.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MeterReadingResponse {

    private Long id;
    private Long assetId;
    private Long tenantId;
    private Double value;
    private LocalDateTime readingDate;
}

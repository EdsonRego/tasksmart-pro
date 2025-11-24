package com.tasksmartpro.report.dto.meter;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MeterReadingDto {
    private Long id;
    private Long assetId;
    private Double value;
    private String readingDate;
}

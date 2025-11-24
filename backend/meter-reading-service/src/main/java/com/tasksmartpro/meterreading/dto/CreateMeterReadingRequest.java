package com.tasksmartpro.meterreading.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateMeterReadingRequest {

    private Long assetId;
    private Long tenantId;
    private Double value;
}

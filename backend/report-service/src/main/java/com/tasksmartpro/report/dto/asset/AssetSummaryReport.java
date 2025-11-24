package com.tasksmartpro.report.dto.asset;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class AssetSummaryReport {
    private String assetName;
    private Integer workOrders;
    private Double lastMeter;
}

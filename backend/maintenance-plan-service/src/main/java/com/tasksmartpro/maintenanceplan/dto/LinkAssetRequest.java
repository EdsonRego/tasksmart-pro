package com.tasksmartpro.maintenanceplan.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LinkAssetRequest {
    private Long tenantId;
    private Long planId;
    private Long assetId;
}

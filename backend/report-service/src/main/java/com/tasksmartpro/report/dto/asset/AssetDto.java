package com.tasksmartpro.report.dto.asset;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AssetDto {
    private Long id;
    private Long tenantId;
    private String name;
    private String category;
}

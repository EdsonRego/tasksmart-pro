package com.tasksmartpro.asset.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetResponse {

    private Long id;
    private Long tenantId;
    private String name;
    private String code;
    private String description;
    private Long categoryId;
    private String categoryName;
    private String status;
    private String location;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

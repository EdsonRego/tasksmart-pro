package com.tasksmartpro.asset.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAssetRequest {

    private String name;
    private String description;
    private Long categoryId;
    private String location;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String status;
}


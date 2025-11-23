package com.tasksmartpro.inventory.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateItemRequest {

    @NotNull
    private Long tenantId;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Integer minimumStock;

    private Long supplierId;
}

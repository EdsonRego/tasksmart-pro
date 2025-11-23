package com.tasksmartpro.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UpdateStockRequest {

    @NotNull
    private Long itemId;

    @NotNull
    private Long tenantId;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotBlank
    private String movementType; // IN / OUT

    private String workOrderId; // futuro
}

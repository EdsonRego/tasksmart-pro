package com.tasksmartpro.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SupplierRequest {

    @NotNull
    private Long tenantId;

    @NotBlank
    private String name;

    private String email;

    private String phone;
}


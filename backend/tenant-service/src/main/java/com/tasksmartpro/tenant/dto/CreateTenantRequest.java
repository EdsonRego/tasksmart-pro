package com.tasksmartpro.tenant.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateTenantRequest {
    private String name;
}

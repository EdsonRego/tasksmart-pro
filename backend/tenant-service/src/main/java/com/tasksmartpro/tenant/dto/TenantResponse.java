package com.tasksmartpro.tenant.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TenantResponse {
    private Long id;
    private String name;
}

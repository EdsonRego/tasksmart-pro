package com.tasksmartpro.asset.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;
    private Long tenantId;
    private String name;
    private String description;
}

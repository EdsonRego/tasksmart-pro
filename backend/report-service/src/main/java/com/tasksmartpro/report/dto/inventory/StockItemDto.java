package com.tasksmartpro.report.dto.inventory;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class StockItemDto {
    private Long id;
    private String name;
    private Integer quantity;
}

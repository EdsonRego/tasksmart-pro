package com.tasksmartpro.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    @Column(nullable = false)
    private String name;

    private String description;

    private Integer stockQuantity;

    private Integer minimumStock;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}

package com.tasksmartpro.asset.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code; // código interno do ativo

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private AssetCategoryEntity category;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;

    private String location;
    private String manufacturer;
    private String model;
    private String serialNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

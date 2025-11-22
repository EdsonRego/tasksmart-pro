package com.tasksmartpro.asset.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asset_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assetId;

    @Column(nullable = false)
    private String metaKey;

    private String metaValue;
}

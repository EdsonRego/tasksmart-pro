package com.tasksmartpro.asset.repository;

import com.tasksmartpro.asset.entity.AssetMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetMetadataRepository extends JpaRepository<AssetMetadataEntity, Long> {
    List<AssetMetadataEntity> findByAssetId(Long assetId);
}

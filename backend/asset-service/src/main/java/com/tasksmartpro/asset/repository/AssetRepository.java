package com.tasksmartpro.asset.repository;

import com.tasksmartpro.asset.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<AssetEntity, Long> {
    List<AssetEntity> findByTenantId(Long tenantId);
}

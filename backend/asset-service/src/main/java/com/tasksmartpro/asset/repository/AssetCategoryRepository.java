package com.tasksmartpro.asset.repository;

import com.tasksmartpro.asset.entity.AssetCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetCategoryRepository extends JpaRepository<AssetCategoryEntity, Long> {
    List<AssetCategoryEntity> findByTenantId(Long tenantId);
}

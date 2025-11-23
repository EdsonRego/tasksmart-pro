package com.tasksmartpro.maintenanceplan.repository;

import com.tasksmartpro.maintenanceplan.entity.PlanAssetLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanAssetLinkRepository extends JpaRepository<PlanAssetLink, Long> {
    List<PlanAssetLink> findByTenantId(Long tenantId);
}

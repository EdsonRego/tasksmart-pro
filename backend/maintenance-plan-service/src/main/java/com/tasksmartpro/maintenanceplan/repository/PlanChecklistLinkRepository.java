package com.tasksmartpro.maintenanceplan.repository;

import com.tasksmartpro.maintenanceplan.entity.PlanChecklistLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanChecklistLinkRepository extends JpaRepository<PlanChecklistLink, Long> {
    List<PlanChecklistLink> findByTenantId(Long tenantId);
}

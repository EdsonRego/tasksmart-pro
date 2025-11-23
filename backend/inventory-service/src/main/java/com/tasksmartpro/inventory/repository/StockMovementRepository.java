package com.tasksmartpro.inventory.repository;

import com.tasksmartpro.inventory.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    List<StockMovement> findByTenantId(Long tenantId);
}

package com.tasksmartpro.inventory.repository;

import com.tasksmartpro.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByTenantId(Long tenantId);
}

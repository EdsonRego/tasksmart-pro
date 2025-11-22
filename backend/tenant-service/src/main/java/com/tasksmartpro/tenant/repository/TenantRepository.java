package com.tasksmartpro.tenant.repository;

import com.tasksmartpro.tenant.entity.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<TenantEntity, Long> {
}


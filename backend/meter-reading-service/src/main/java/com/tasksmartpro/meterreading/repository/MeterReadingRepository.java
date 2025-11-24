package com.tasksmartpro.meterreading.repository;

import com.tasksmartpro.meterreading.entity.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
    List<MeterReading> findByAssetId(Long assetId);
    List<MeterReading> findByTenantId(Long tenantId);
}

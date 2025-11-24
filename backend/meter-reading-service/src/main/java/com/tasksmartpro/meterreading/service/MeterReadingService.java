package com.tasksmartpro.meterreading.service;

import com.tasksmartpro.meterreading.dto.*;
import com.tasksmartpro.meterreading.entity.MeterReading;
import com.tasksmartpro.meterreading.exception.NotFoundException;
import com.tasksmartpro.meterreading.repository.MeterReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeterReadingService {

    private final MeterReadingRepository repo;

    // CREATE
    public MeterReadingResponse createReading(CreateMeterReadingRequest request) {

        MeterReading reading = MeterReading.builder()
                .assetId(request.getAssetId())
                .tenantId(request.getTenantId())
                .value(request.getValue())
                .build();

        MeterReading saved = repo.save(reading);

        return toResponse(saved);
    }

    // GET ALL
    public List<MeterReadingResponse> findAll() {
        return repo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // GET BY ID
    public MeterReadingResponse findById(Long id) {
        MeterReading reading = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Meter reading not found: " + id));
        return toResponse(reading);
    }

    // GET BY ASSET
    public List<MeterReadingResponse> findByAsset(Long assetId) {
        return repo.findByAssetId(assetId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // DELETE
    public void delete(Long id) {
        MeterReading reading = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Meter reading not found: " + id));

        repo.delete(reading);
    }

    // Mapper interno
    private MeterReadingResponse toResponse(MeterReading saved) {
        return MeterReadingResponse.builder()
                .id(saved.getId())
                .assetId(saved.getAssetId())
                .tenantId(saved.getTenantId())
                .value(saved.getValue())
                .readingDate(saved.getReadingDate())
                .build();
    }
}

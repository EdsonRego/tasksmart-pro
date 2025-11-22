package com.tasksmartpro.asset.service;

import com.tasksmartpro.asset.dto.*;
import com.tasksmartpro.asset.entity.*;
import com.tasksmartpro.asset.exception.NotFoundException;
import com.tasksmartpro.asset.repository.AssetCategoryRepository;
import com.tasksmartpro.asset.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;
    private final AssetCategoryRepository categoryRepository;

    public AssetResponse create(CreateAssetRequest request) {

        AssetCategoryEntity category = null;
        if (request.getCategoryId() != null) {
            category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new NotFoundException("Category not found"));
        }

        AssetEntity entity = AssetEntity.builder()
                .tenantId(request.getTenantId())
                .name(request.getName())
                .code(request.getCode())
                .description(request.getDescription())
                .category(category)
                .status(request.getStatus() != null
                        ? AssetStatus.valueOf(request.getStatus())
                        : AssetStatus.ACTIVE)
                .location(request.getLocation())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .serialNumber(request.getSerialNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        AssetEntity saved = assetRepository.save(entity);
        return toResponse(saved);
    }

    public AssetResponse update(Long id, UpdateAssetRequest request) {

        AssetEntity entity = assetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Asset not found"));

        if (request.getCategoryId() != null) {
            AssetCategoryEntity category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new NotFoundException("Category not found"));
            entity.setCategory(category);
        }

        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLocation(request.getLocation());
        entity.setManufacturer(request.getManufacturer());
        entity.setModel(request.getModel());
        entity.setSerialNumber(request.getSerialNumber());

        if (request.getStatus() != null) {
            entity.setStatus(AssetStatus.valueOf(request.getStatus()));
        }

        entity.setUpdatedAt(LocalDateTime.now());

        return toResponse(assetRepository.save(entity));
    }

    public AssetResponse getById(Long id) {
        AssetEntity entity = assetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Asset not found"));
        return toResponse(entity);
    }

    public List<AssetResponse> listByTenant(Long tenantId) {
        return assetRepository.findByTenantId(tenantId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void delete(Long id) {
        assetRepository.deleteById(id);
    }

    private AssetResponse toResponse(AssetEntity e) {
        return AssetResponse.builder()
                .id(e.getId())
                .tenantId(e.getTenantId())
                .name(e.getName())
                .code(e.getCode())
                .description(e.getDescription())
                .categoryId(e.getCategory() != null ? e.getCategory().getId() : null)
                .categoryName(e.getCategory() != null ? e.getCategory().getName() : null)
                .status(e.getStatus() != null ? e.getStatus().name() : null)
                .location(e.getLocation())
                .manufacturer(e.getManufacturer())
                .model(e.getModel())
                .serialNumber(e.getSerialNumber())
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }
}

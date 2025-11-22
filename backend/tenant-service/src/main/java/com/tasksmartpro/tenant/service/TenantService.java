package com.tasksmartpro.tenant.service;

import com.tasksmartpro.tenant.dto.CreateTenantRequest;
import com.tasksmartpro.tenant.dto.TenantResponse;
import com.tasksmartpro.tenant.entity.TenantEntity;
import com.tasksmartpro.tenant.exception.TenantNotFoundException;
import com.tasksmartpro.tenant.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository repository;

    @Transactional
    public TenantResponse createTenant(CreateTenantRequest request, String ownerEmail) {

        TenantEntity entity = TenantEntity.builder()
                .name(request.getName())
                .emailOwner(ownerEmail)
                .build();

        TenantEntity saved = repository.save(entity);

        return TenantResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .build();
    }

    public TenantResponse getTenant(Long id) {
        TenantEntity tenant = repository.findById(id)
                .orElseThrow(() -> new TenantNotFoundException("Tenant não encontrado"));

        return TenantResponse.builder()
                .id(tenant.getId())
                .name(tenant.getName())
                .build();
    }
}


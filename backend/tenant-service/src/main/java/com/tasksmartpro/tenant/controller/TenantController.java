package com.tasksmartpro.tenant.controller;

import com.tasksmartpro.tenant.dto.CreateTenantRequest;
import com.tasksmartpro.tenant.dto.TenantResponse;
import com.tasksmartpro.tenant.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping
    public ResponseEntity<TenantResponse> createTenant(
            @RequestBody CreateTenantRequest request,
            @RequestHeader("X-User-Email") String ownerEmail
    ) {
        return ResponseEntity.ok(tenantService.createTenant(request, ownerEmail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tenantService.getTenant(id));
    }
}

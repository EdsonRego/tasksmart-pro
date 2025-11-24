package com.tasksmartpro.auditlog.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "tenant-service",
        url = "http://localhost:8082/tenants"
)
public interface TenantClient {

    @GetMapping("/{id}")
    Object getTenantById(@PathVariable("id") Long id);
}

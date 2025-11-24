package com.tasksmartpro.auditlog.feign;

import com.tasksmartpro.auditlog.dto.AuthUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "auth-service",
        url = "http://localhost:8081/auth" // depois podemos trocar para o gateway
)
public interface AuthClient {

    @GetMapping("/users/{id}")
    AuthUserResponse getUserById(@PathVariable("id") Long id);
}

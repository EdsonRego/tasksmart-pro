package com.tasksmartpro.userprofile.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service", url = "http://localhost:8081/auth")
public interface AuthClient {

    @GetMapping("/users/{id}")
    Object getUserById(@PathVariable("id") Long id);
}

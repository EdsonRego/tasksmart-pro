package com.tasksmartpro.analytics.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "checklist-service",
        url = "${CHECKLIST_SERVICE_URL:http://localhost:8083/checklists}"
)
public interface ChecklistClient {

    @GetMapping("/count/pending")
    Integer countPending();
}

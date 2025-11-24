package com.tasksmartpro.report.client;

import com.tasksmartpro.report.dto.checklist.ChecklistDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "checklist-service", url = "http://localhost:8083")
public interface ChecklistClient {

    @GetMapping("/checklists")
    List<ChecklistDto> findAll();
}

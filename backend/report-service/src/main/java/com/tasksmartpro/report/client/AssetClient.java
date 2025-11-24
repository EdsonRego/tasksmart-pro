package com.tasksmartpro.report.client;

import com.tasksmartpro.report.dto.asset.AssetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "asset-service", url = "http://localhost:8086")
public interface AssetClient {

    @GetMapping("/assets")
    List<AssetDto> findAll();

    @GetMapping("/assets/{id}")
    AssetDto findById(@PathVariable Long id);
}

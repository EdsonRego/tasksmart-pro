package com.tasksmartpro.report.controller;

import com.tasksmartpro.report.dto.asset.AssetSummaryReport;
import com.tasksmartpro.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService service;

    @GetMapping("/assets/summary")
    public ResponseEntity<List<AssetSummaryReport>> getAssetSummary() {
        return ResponseEntity.ok(service.getAssetSummary());
    }
}

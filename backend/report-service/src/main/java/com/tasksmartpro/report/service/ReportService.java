package com.tasksmartpro.report.service;

import com.tasksmartpro.report.client.*;
import com.tasksmartpro.report.dto.asset.AssetSummaryReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final AssetClient assetClient;
    private final WorkOrderClient workOrderClient;
    private final MeterClient meterClient;

    public List<AssetSummaryReport> getAssetSummary() {

        var assets = assetClient.findAll();
        var workorders = workOrderClient.findAll();

        List<AssetSummaryReport> reports = new ArrayList<>();

        assets.forEach(asset -> {
            var meter = meterClient.findByAsset(asset.getId());
            var woCount = workorders.stream()
                    .filter(x -> Objects.equals(x.getAssetId(), asset.getId()))
                    .count();

            reports.add(AssetSummaryReport.builder()
                    .assetName(asset.getName())
                    .workOrders((int) woCount)
                    .lastMeter(meter.isEmpty() ? null : meter.get(meter.size()-1).getValue())
                    .build());
        });

        return reports;
    }
}

package com.cts.mapper;

import com.cts.dto.request.CreateKPIRequest; 
import com.cts.dto.request.UpdateKPIRequest;
import com.cts.dto.response.KPIResponse;
import com.cts.entity.KPI;

public class KPIMapper {

    public static KPI toEntity(CreateKPIRequest req) {
        return KPI.builder()
                .name(req.getName())
                .definition(req.getDefinition())
                .target(req.getTarget())
                .currentValue(req.getCurrentValue())
                .reportingPeriod(req.getReportingPeriod())
                .operationsManagerId(req.getOperationsManagerId())
                .build();
    }

    public static KPIResponse toResponse(KPI k) {
        return KPIResponse.builder()
                .kpiId(k.getKpiId())
                .name(k.getName())
                .definition(k.getDefinition())
                .target(k.getTarget())
                .currentValue(k.getCurrentValue())
                .reportingPeriod(k.getReportingPeriod())
                .operationsManagerId(k.getOperationsManagerId())
                .createdAt(k.getCreatedAt())
                .updatedAt(k.getUpdatedAt())
                .build();
    }

    public static void updateEntity(KPI k, UpdateKPIRequest req) {
        k.setName(req.getName());
        k.setDefinition(req.getDefinition());
        k.setTarget(req.getTarget());
        k.setCurrentValue(req.getCurrentValue());
        k.setReportingPeriod(req.getReportingPeriod());
        k.setOperationsManagerId(req.getOperationsManagerId());
    }
}

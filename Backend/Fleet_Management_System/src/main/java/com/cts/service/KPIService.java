package com.cts.service;

import com.cts.dto.request.CreateKPIRequest;
import com.cts.dto.request.UpdateKPIRequest;
import com.cts.dto.response.KPIResponse;
import com.cts.entity.KPI;
import java.util.List;

public interface KPIService {
    KPIResponse createKPI(CreateKPIRequest request);
    KPI deleteKPI(Long id);
    KPIResponse updateKPI(Long id, UpdateKPIRequest request);
    KPIResponse getKPIById(Long id);
    List<KPIResponse> getAllKPIs();
    List<KPIResponse> getByOperationsManager(Long operationsManagerId);
    List<KPIResponse> getByReportingPeriod(String reportingPeriod);
}
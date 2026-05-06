package com.cts.service.imp;

import com.cts.dto.request.CreateKPIRequest; 
import com.cts.dto.request.UpdateKPIRequest;
import com.cts.dto.response.KPIResponse;
import com.cts.entity.KPI;
import com.cts.enums.ReportingPeriod;
import com.cts.exception.NotExistException;
import com.cts.mapper.KPIMapper;
import com.cts.repository.KPIRepository;
import com.cts.service.KPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPIServiceImpl implements KPIService {

    private final KPIRepository kpiRepository;

    @Override
    public KPIResponse createKPI(CreateKPIRequest request) {
        KPI kpi = KPIMapper.toEntity(request);
        KPI saved = kpiRepository.save(kpi);
        return KPIMapper.toResponse(saved);
    }

    @Override
    public KPI deleteKPI(Long id) {
        KPI existing = kpiRepository.findByKpiId(id);
        if (existing == null) {
            throw new NotExistException("KPI not found with id: " + id);
        }
        kpiRepository.deleteById(id);
        return existing;
    }

    @Override
    public KPIResponse updateKPI(Long id, UpdateKPIRequest request) {

        KPI kpi = kpiRepository.findById(id)
                .orElseThrow(() ->
                        new NotExistException("KPI not found with id: " + id));

        if (request.getName() != null) {
            kpi.setName(request.getName());
        }

        if (request.getDefinition() != null) {
            kpi.setDefinition(request.getDefinition());
        }

        if (request.getTarget() != null) {
            kpi.setTarget(request.getTarget());
        }

        if (request.getCurrentValue() != null) {
            kpi.setCurrentValue(request.getCurrentValue());
        }

        if (request.getReportingPeriod() != null) {
            kpi.setReportingPeriod(request.getReportingPeriod());
        }

        if (request.getOperationsManagerId() != null) {
            kpi.setOperationsManagerId(request.getOperationsManagerId());
        }

        KPI updated = kpiRepository.save(kpi);

        return KPIMapper.toResponse(updated);
    }
    

    @Override
    public KPIResponse getKPIById(Long id) {
        KPI kpi = kpiRepository.findById(id)
                .orElseThrow(() -> new NotExistException("KPI not found with id: " + id));
        return KPIMapper.toResponse(kpi);
    }

    @Override
    public List<KPIResponse> getAllKPIs() {
        return kpiRepository.findAll()
                .stream()
                .map(KPIMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<KPIResponse> getByOperationsManager(Long operationsManagerId) {
        return kpiRepository.findByOperationsManagerId(operationsManagerId)
                .stream()
                .map(KPIMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<KPIResponse> getByReportingPeriod(String reportingPeriod) {
        ReportingPeriod period = ReportingPeriod.valueOf(reportingPeriod.toUpperCase());
        return kpiRepository.findByReportingPeriod(period)
                .stream()
                .map(KPIMapper::toResponse)
                .collect(Collectors.toList());
    }
}
package com.cts.service.imp;

import com.cts.dto.request.CreatePassengerReportRequest;
import com.cts.dto.request.UpdatePassengerReportRequest;
import com.cts.dto.response.PassengerReportResponse;
import com.cts.entity.Passenger;
import com.cts.entity.PassengerReport;
import com.cts.entity.RouteSchedule;
import com.cts.enums.AuditAction;
import com.cts.exception.NotExistException;
import com.cts.mapper.PassengerReportMapper;
import com.cts.repository.PassengerReportRepository;
import com.cts.repository.PassengerRepository;
import com.cts.repository.RouteScheduleRepository;
import com.cts.service.PassengerReportService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerReportServiceImpl implements PassengerReportService {

    private final PassengerRepository passengerRepository;
    private final PassengerReportRepository reportRepository;
    private final RouteScheduleRepository routeScheduleRepository;

    @Override
    public PassengerReportResponse createReport(Long passengerId, CreatePassengerReportRequest request) {

        
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new NotExistException("Passenger not found with id: " + passengerId));
        RouteSchedule schedule = routeScheduleRepository.findById(request.getScheduleId())
                .orElseThrow(() -> new NotExistException("Route Schedule not found"));
        
        PassengerReport report = PassengerReportMapper.toEntity(request, passenger);

        PassengerReport saved = reportRepository.save(report);
        return PassengerReportMapper.toResponse(saved);
    }
    @Override
    @Transactional
    public PassengerReportResponse updateReport(Long reportId, Long passengerId, UpdatePassengerReportRequest request) {

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new NotExistException("Passenger not found"));

        PassengerReport report = reportRepository.findById(reportId)
                .orElseThrow(() -> new NotExistException("Report not found"));
        
        RouteSchedule schedule = routeScheduleRepository.findById(request.getScheduleId())
                .orElseThrow(() -> new NotExistException("Route Schedule not found"));
        
        if (!report.getPassenger().getPassengerId().equals(passengerId)) {
            throw new RuntimeException("Passenger does not have permission to edit this report");
        }

        if (request.getDescription() != null) {
            report.setDescription(request.getDescription());
        }

       
        if (request.getCategory() != null) {
            report.setCategory(request.getCategory().toUpperCase());
        }
        if(request.getStatus()!=null) {
        	report.setStatus(AuditAction.valueOf(request.getStatus().toUpperCase()));
        }
        PassengerReport saved = reportRepository.save(report);

        return PassengerReportMapper.toResponse(saved);
    }
    @Override
    public PassengerReportResponse getReportById(Long reportId) {
        PassengerReport report = reportRepository.findById(reportId)
                .orElseThrow(() -> new NotExistException("Report not found"));

        return PassengerReportMapper.toResponse(report);
    }

    @Override
    public List<PassengerReportResponse> getAllReports() {
        return reportRepository.findAll()
                .stream()
                .map(PassengerReportMapper::toResponse)
                .toList();
    }

    @Override
    public List<PassengerReportResponse> getReportsByPassengerId(Long passengerId) {
        return reportRepository.findByPassenger_PassengerId(passengerId)
                .stream()
                .map(PassengerReportMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteReportById(Long reportId) {
        PassengerReport report = reportRepository.findById(reportId)
                .orElseThrow(() -> new NotExistException("Report not found"));
        
        reportRepository.delete(report);
    }
    

}
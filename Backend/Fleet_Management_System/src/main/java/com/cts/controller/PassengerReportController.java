
package com.cts.controller;

import com.cts.api.APIResponse; 
import com.cts.dto.request.CreatePassengerReportRequest;
import com.cts.dto.request.UpdatePassengerReportRequest;
import com.cts.dto.response.PassengerReportResponse;
import com.cts.entity.PassengerReport;
import com.cts.exception.NotExistException;
import com.cts.repository.PassengerReportRepository;
import com.cts.service.FileStorageService;
import com.cts.service.PassengerReportService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/passenger-reports")
@RequiredArgsConstructor
public class PassengerReportController {

    private final PassengerReportService reportService;

    @PostMapping("/passengers/{passengerId}/reports")
    public ResponseEntity<APIResponse<PassengerReportResponse>> createReport(
            @PathVariable Long passengerId,
            @Valid @RequestBody CreatePassengerReportRequest request) {
    		
        	PassengerReportResponse response = reportService.createReport(passengerId, request);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Report created", response)
        );
    }
    @PutMapping("/passengers/{passengerId}/reports/{reportId}")
    public ResponseEntity<APIResponse<PassengerReportResponse>> updateReport(
            @PathVariable Long passengerId,
            @PathVariable Long reportId,
            @Valid @RequestBody UpdatePassengerReportRequest request) {

        PassengerReportResponse response = reportService.updateReport(reportId, passengerId, request);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Report updated successfully", response)
        );
    }

    @GetMapping("/GETALL")
    public ResponseEntity<APIResponse<List<PassengerReportResponse>>> getAllReports() {
        List<PassengerReportResponse> reports = reportService.getAllReports();
        return ResponseEntity.ok(new APIResponse<>("success", "All reports fetched", reports));
    }

    @GetMapping("/report/{reportId}")
    public ResponseEntity<APIResponse<PassengerReportResponse>> getReportById(@PathVariable Long reportId) {
        PassengerReportResponse response = reportService.getReportById(reportId);
        return ResponseEntity.ok(new APIResponse<>("success", "Report found", response));
    }

    @GetMapping("/passengers/{passengerId}")
    public ResponseEntity<APIResponse<List<PassengerReportResponse>>> getReportsByPassengerId(
            @PathVariable Long passengerId) {

        List<PassengerReportResponse> responses = reportService.getReportsByPassengerId(passengerId);
        return ResponseEntity.ok(new APIResponse<>("success", "Reports for passenger fetched", responses));
    }

    @DeleteMapping("/delete/{reportId}")
    public ResponseEntity<APIResponse<String>> deleteReportById(@PathVariable Long reportId) {

        reportService.deleteReportById(reportId);

        return ResponseEntity.ok(new APIResponse<>("success", "Report deleted", null));
    }
   


}

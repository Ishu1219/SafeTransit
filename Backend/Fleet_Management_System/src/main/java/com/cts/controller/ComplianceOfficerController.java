package com.cts.controller;

import com.cts.dto.request.CreateComplianceOfficerRequest; 
import com.cts.dto.request.UpdateComplianceOfficerRequest;
import com.cts.dto.response.ComplianceOfficerResponse;
import com.cts.entity.ComplianceOfficer;
import com.cts.api.APIResponse;
import com.cts.service.ComplianceOfficerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compliance-officers")
@RequiredArgsConstructor
public class ComplianceOfficerController {

    private final ComplianceOfficerService service;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<ComplianceOfficerResponse>> createOfficer(
            @Valid @RequestBody CreateComplianceOfficerRequest request) {
        ComplianceOfficerResponse response = service.createOfficer(request);
        APIResponse<ComplianceOfficerResponse> apiResponse = new APIResponse<>(
                "success", "Compliance officer created successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<ComplianceOfficer>> deleteOfficer(@PathVariable Long id) {
        ComplianceOfficer response = service.deleteOfficer(id);
        APIResponse<ComplianceOfficer> apiResponse = new APIResponse<>(
                "success", "Compliance officer deleted successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<ComplianceOfficerResponse>> updateOfficer(
            @PathVariable Long id,
           @Valid @RequestBody UpdateComplianceOfficerRequest request) {
        ComplianceOfficerResponse response = service.updateOfficer(id, request);
        APIResponse<ComplianceOfficerResponse> apiResponse = new APIResponse<>(
                "success", "Compliance officer updated successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<List<ComplianceOfficerResponse>>> getAllOfficers() {
        List<ComplianceOfficerResponse> response = service.getAllOfficers();
        APIResponse<List<ComplianceOfficerResponse>> apiResponse = new APIResponse<>(
                "success", "Compliance officers fetched successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ComplianceOfficerResponse>> getOfficerById(@PathVariable Long id) {
        ComplianceOfficerResponse response = service.getOfficerById(id);
        APIResponse<ComplianceOfficerResponse> apiResponse = new APIResponse<>(
                "success", "Compliance officer fetched successfully", response);
        return ResponseEntity.ok(apiResponse);
    }
}

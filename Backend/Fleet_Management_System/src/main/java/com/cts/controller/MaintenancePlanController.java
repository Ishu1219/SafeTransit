package com.cts.controller;

import com.cts.api.APIResponse; 
import com.cts.dto.request.CreateMaintenancePlanRequest;
import com.cts.dto.request.UpdateMaintenancePlanRequest;
import com.cts.dto.response.MaintenancePlanResponse;
import com.cts.entity.MaintenancePlan;
import com.cts.service.MaintenancePlanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/maintenance-plans")
@RequiredArgsConstructor
public class MaintenancePlanController {

    private final MaintenancePlanService planService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<MaintenancePlanResponse>> createPlan(
           @Valid @RequestBody CreateMaintenancePlanRequest request) {
        MaintenancePlanResponse response = planService.createPlan(request);
        APIResponse<MaintenancePlanResponse> apiResponse = new APIResponse<>(
                "success", "Maintenance plan created successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<MaintenancePlan>> deletePlan(@PathVariable Long id) {
        MaintenancePlan response = planService.deletePlan(id);
        APIResponse<MaintenancePlan> apiResponse = new APIResponse<>(
                "success", "Maintenance plan deleted successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<MaintenancePlanResponse>> updatePlan(
            @PathVariable Long id,
          @Valid  @RequestBody UpdateMaintenancePlanRequest request) {
        MaintenancePlanResponse response = planService.updatePlan(id, request);
        APIResponse<MaintenancePlanResponse> apiResponse = new APIResponse<>(
                "success", "Maintenance plan updated successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<APIResponse<MaintenancePlanResponse>> getById(@PathVariable Long id) {
        MaintenancePlanResponse response = planService.getPlanById(id);
        APIResponse<MaintenancePlanResponse> apiResponse = new APIResponse<>(
                "success", "Maintenance plan fetched successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<MaintenancePlanResponse>>> getAll() {
        List<MaintenancePlanResponse> response = planService.getAllPlans();
        APIResponse<List<MaintenancePlanResponse>> apiResponse = new APIResponse<>(
                "success", "All maintenance plans fetched successfully", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<APIResponse<List<MaintenancePlanResponse>>> getByVehicle(
            @PathVariable Long vehicleId) {
        List<MaintenancePlanResponse> response = planService.getByVehicle(vehicleId);
        APIResponse<List<MaintenancePlanResponse>> apiResponse = new APIResponse<>(
                "success", "Plans fetched for vehicle: " + vehicleId, response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<APIResponse<List<MaintenancePlanResponse>>> getByStatus(
            @PathVariable String status) {
        List<MaintenancePlanResponse> response = planService.getByStatus(status);
        APIResponse<List<MaintenancePlanResponse>> apiResponse = new APIResponse<>(
                "success", "Plans fetched by status: " + status, response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/overdue")
    public ResponseEntity<APIResponse<List<MaintenancePlanResponse>>> getOverdue() {
        List<MaintenancePlanResponse> response = planService.getOverduePlans();
        APIResponse<List<MaintenancePlanResponse>> apiResponse = new APIResponse<>(
                "success", "Overdue maintenance plans fetched successfully", response);
        return ResponseEntity.ok(apiResponse);
    }
}
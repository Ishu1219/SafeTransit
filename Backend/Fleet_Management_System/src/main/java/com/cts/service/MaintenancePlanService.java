package com.cts.service;

import com.cts.dto.request.CreateMaintenancePlanRequest;
import com.cts.dto.request.UpdateMaintenancePlanRequest;
import com.cts.dto.response.MaintenancePlanResponse;
import com.cts.entity.MaintenancePlan;
import java.util.List;

public interface MaintenancePlanService {
    MaintenancePlanResponse createPlan(CreateMaintenancePlanRequest request);
    MaintenancePlan deletePlan(Long id);
    MaintenancePlanResponse updatePlan(Long id, UpdateMaintenancePlanRequest request);
    MaintenancePlanResponse getPlanById(Long id);
    List<MaintenancePlanResponse> getAllPlans();
    List<MaintenancePlanResponse> getByVehicle(Long vehicleId);
    List<MaintenancePlanResponse> getByStatus(String status);
    List<MaintenancePlanResponse> getOverduePlans();
}
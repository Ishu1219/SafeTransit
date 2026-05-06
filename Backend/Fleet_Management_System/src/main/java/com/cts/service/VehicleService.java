package com.cts.service;

import com.cts.dto.request.CreateVehicleRequest;
import com.cts.dto.request.UpdateVehicleRequest;
import com.cts.dto.response.VehicleResponse;
import com.cts.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    VehicleResponse createVehicle(CreateVehicleRequest request);
    Vehicle deleteVehicle(Long id);
    VehicleResponse updateVehicle(Long id, UpdateVehicleRequest request);
    VehicleResponse getVehicleById(Long id);
    List<VehicleResponse> getAllVehicles();
    List<VehicleResponse> getVehiclesByStatus(String status);
}
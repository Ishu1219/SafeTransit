package com.cts.mapper;

import com.cts.dto.request.CreateVehicleRequest;
import com.cts.dto.response.VehicleResponse;
import com.cts.entity.Vehicle;
import com.cts.enums.VehicleStatus;

public class VehicleMapper {

  
    public static Vehicle toEntity(CreateVehicleRequest req) {
        return Vehicle.builder()
                .regNumber(req.getRegNumber())
                .capacity(req.getCapacity())
                .model(req.getModel())
                .manufacturer(req.getManufacturer())
                .yearOfManufacture(req.getYearOfManufacture())
                .fuelType(req.getFuelType())
                .status(VehicleStatus.ACTIVE)
                .build();
    }

  
    public static VehicleResponse toResponse(Vehicle v) {
        return VehicleResponse.builder()
                .vehicleId(v.getVehicleId())
                .regNumber(v.getRegNumber())
                .capacity(v.getCapacity())
                .model(v.getModel())
                .manufacturer(v.getManufacturer())
                .yearOfManufacture(v.getYearOfManufacture())
                .fuelType(v.getFuelType())
                .status(v.getStatus())
                .createdAt(v.getCreatedAt())
                .updatedAt(v.getUpdatedAt())
                .build();
    }
}
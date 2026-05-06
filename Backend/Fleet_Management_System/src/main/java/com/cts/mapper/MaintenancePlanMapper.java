package com.cts.mapper;

import com.cts.dto.response.MaintenancePlanResponse;
import com.cts.entity.MaintenancePlan;

public class MaintenancePlanMapper {

    public static MaintenancePlanResponse toResponse(MaintenancePlan p) {
        return MaintenancePlanResponse.builder()
                .planId(p.getPlanId())
                .vehicleId(p.getVehicle().getVehicleId())
                .fleetManager(p.getFleetManager().getFleetManagerId())
                .vehicleRegNumber(p.getVehicle().getRegNumber())
                .frequencyDays(p.getFrequencyDays())
                .nextDueDate(p.getNextDueDate())
                .status(p.getStatus())
                .createdAt(p.getCreatedAt())
                .updatedAt(p.getUpdatedAt())
                .build();
    }
}


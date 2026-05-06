package com.cts.mapper;

import com.cts.dto.response.MaintenanceRecordResponse;
import com.cts.entity.MaintenanceRecord;

public class MaintenanceRecordMapper {

    public static MaintenanceRecordResponse toResponse(MaintenanceRecord m) {
        return MaintenanceRecordResponse.builder()
                .maintId(m.getMaintId())
                .vehicleId(m.getVehicle().getVehicleId())
                .vehicleRegNumber(m.getVehicle().getRegNumber())
                .taskDescription(m.getTaskDescription())
                .performedBy(m.getPerformedBy())
                .performedAt(m.getPerformedAt())
                .cost(m.getCost())
                .status(m.getStatus())
                .createdAt(m.getCreatedAt())
                .updatedAt(m.getUpdatedAt())
                .fleetManger(m.getFleetManager().getFleetManagerId())
                .build();
    }
}
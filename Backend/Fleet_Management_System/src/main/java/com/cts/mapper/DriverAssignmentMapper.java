package com.cts.mapper;

import com.cts.dto.request.CreateDriverAssignmentRequest;
import com.cts.dto.response.DriverAssignmentResponse;
import com.cts.entity.*;
import com.cts.enums.DriverAssignmentStatus;

import java.time.LocalDateTime;

public class DriverAssignmentMapper {

    public static DriverAssignment toEntity(
            CreateDriverAssignmentRequest request,
            Driver driver,
            Vehicle vehicle,
            Route route,
            Dispatcher dispatcher) {

        return DriverAssignment.builder()
                .driver(driver)
                .vehicle(vehicle)
                .route(route)
                .assignedBy(dispatcher)
                .assignedAt(LocalDateTime.now())
                .status(DriverAssignmentStatus.ASSIGNED)
                .build();
    }

    public static DriverAssignmentResponse toResponse(DriverAssignment da) {

        return DriverAssignmentResponse.builder()
                .assignId(da.getAssignId())
                .driverId(da.getDriver().getDriverId())
                .driverName(da.getDriver().getName())
                .vehicleId(da.getVehicle().getVehicleId())
                .vehicleRegNumber(da.getVehicle().getRegNumber())
                .routeId(da.getRoute().getRouteId())
                .routeName(da.getRoute().getRouteName())
                .dispatcherId(da.getAssignedBy().getDispatcherId())
                .dispatcherName(da.getAssignedBy().getName())
                .assignedAt(da.getAssignedAt())
                .status(da.getStatus())
                .createdAt(da.getCreatedAt())
                .updatedAt(da.getUpdatedAt())
                .build();
    }
}
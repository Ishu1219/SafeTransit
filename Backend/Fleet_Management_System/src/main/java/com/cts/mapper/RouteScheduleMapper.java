package com.cts.mapper;

import com.cts.dto.request.CreateRouteScheduleRequest;
import com.cts.dto.response.RouteScheduleResponse;
import com.cts.entity.*;
import com.cts.enums.RouteScheduleStatus;

import java.time.LocalDate;

public class RouteScheduleMapper {

 
    public static RouteSchedule toEntity(
            CreateRouteScheduleRequest request,
            Route route,
            Vehicle vehicle,
            Dispatcher dispatcher) {

        return RouteSchedule.builder()
                .route(route)
                .vehicle(vehicle)
                .dispatcher(dispatcher)
                .scheduleDate(LocalDate.parse(request.getScheduleDate()))
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .status(RouteScheduleStatus.PLANNED)
                .build();
    }

   
    public static RouteScheduleResponse toResponse(RouteSchedule rs) {

        return RouteScheduleResponse.builder()
                .scheduleId(rs.getScheduleId())
                .routeId(rs.getRoute().getRouteId())
                .routeName(rs.getRoute().getRouteName())
                .vehicleId(rs.getVehicle().getVehicleId())
                .vehicleRegNumber(rs.getVehicle().getRegNumber())
                .dispatcherId(rs.getDispatcher().getDispatcherId())
                .dispatcherName(rs.getDispatcher().getName())
                .scheduleDate(rs.getScheduleDate().toString())
                .startTime(rs.getStartTime())
                .endTime(rs.getEndTime())
                .status(rs.getStatus())
                .createdAt(rs.getCreatedAt())
                .updatedAt(rs.getUpdatedAt())
                .build();
    }
}

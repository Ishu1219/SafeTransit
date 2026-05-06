package com.cts.mapper;

import com.cts.dto.request.CreatePassengerReportRequest;
import com.cts.dto.response.PassengerReportResponse;
import com.cts.entity.Passenger;
import com.cts.entity.PassengerReport;
import com.cts.enums.AuditAction;

public class PassengerReportMapper {

    public static PassengerReport toEntity(CreatePassengerReportRequest req, Passenger passenger) {
        return PassengerReport.builder()
                .passenger(passenger)
                .description(req.getDescription())
                .category(req.getCategory())
                .status(AuditAction.SUBMITTED)
                .scheduleId(req.getScheduleId())
                .build();
    }

    public static PassengerReportResponse toResponse(PassengerReport r) {
        return PassengerReportResponse.builder()
                .reportId(r.getReportId())
                .passengerId(r.getPassenger().getPassengerId())
                .description(r.getDescription())
                .category(r.getCategory())
                .status(r.getStatus())
                .scheduleId(r.getScheduleId())
                .createdAt(r.getCreatedAt())
                .updatedAt(r.getUpdatedAt())
                .build();
    }
}
package com.cts.dto.response;

import com.cts.enums.DriverAssignmentStatus;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverAssignmentResponse {

    private Long assignId;

    private Long driverId;
    private String driverName;

    private Long vehicleId;
    private String vehicleRegNumber;

    private Integer routeId;
    private String routeName;

    private Long dispatcherId;
    private String dispatcherName;

    private LocalDateTime assignedAt;
    private DriverAssignmentStatus status;

    private Instant createdAt;
    private Instant updatedAt;
}
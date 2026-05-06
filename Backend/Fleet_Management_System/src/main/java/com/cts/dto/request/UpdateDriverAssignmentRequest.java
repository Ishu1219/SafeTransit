package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDriverAssignmentRequest {

    @Positive(message = "Driver ID must be a positive number")
    private Long driverId;

    @Positive(message = "Vehicle ID must be a positive number")
    private Long vehicleId;

    @Positive(message = "Route ID must be a positive number")
    private Integer routeId;

    private String status;

    @Positive(message = "Dispatcher ID must be a positive number")
    private Long dispatcherId;
}
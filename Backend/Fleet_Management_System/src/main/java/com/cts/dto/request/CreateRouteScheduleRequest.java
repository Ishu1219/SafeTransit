package com.cts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRouteScheduleRequest {

   
    @NotNull(message = "Route ID is required")
    private Integer routeId;

    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

    @NotNull(message = "Dispatcher ID is required")
    private Long dispatcherId;

   
    @NotBlank(message = "Schedule date is required")
    private String scheduleDate;

    @NotBlank(message = "Start time is required")
    private String startTime;

    @NotBlank(message = "End time is required")
    private String endTime;
}

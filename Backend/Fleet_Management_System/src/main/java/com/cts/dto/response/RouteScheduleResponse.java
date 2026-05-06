package com.cts.dto.response;

import com.cts.enums.RouteScheduleStatus;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteScheduleResponse {

    private Long scheduleId;

    private Integer routeId;
    private String routeName;

    private Long vehicleId;    
    private String vehicleRegNumber;

    private Long dispatcherId;
    private String dispatcherName;

    private String scheduleDate;
    private String startTime;
    private String endTime;

    private RouteScheduleStatus status;

    private Instant createdAt;
    private Instant updatedAt;
}
package com.cts.dto.response;

import com.cts.enums.MaintenancePlanStatus;
import lombok.*;
import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenancePlanResponse {
    private Long planId;
    private Long vehicleId;
    private Long fleetManager;
    private String vehicleRegNumber;
    private Integer frequencyDays;
    private LocalDate nextDueDate;
    private MaintenancePlanStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
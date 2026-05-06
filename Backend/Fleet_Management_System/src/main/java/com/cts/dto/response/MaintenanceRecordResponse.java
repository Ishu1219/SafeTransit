package com.cts.dto.response;

import com.cts.enums.MaintenanceStatus;
import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceRecordResponse {
    private Long maintId;
    private Long vehicleId;
    private String vehicleRegNumber;
    private String taskDescription;
    private String performedBy;
    private Instant performedAt;
    private Double cost;
    private Long fleetManger;
    private MaintenanceStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}

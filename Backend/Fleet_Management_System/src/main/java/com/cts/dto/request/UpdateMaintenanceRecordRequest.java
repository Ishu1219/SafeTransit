package com.cts.dto.request;

import com.cts.enums.MaintenanceStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMaintenanceRecordRequest {

    @Positive(message = "Vehicle ID must be a positive number")
    private Long vehicleId;

    @Size(min = 5, max = 500, message = "Task description must be between 5 and 500 characters")
    private String taskDescription;

    @Size(min = 3, max = 100, message = "Performed by must be between 3 and 100 characters")
    private String performedBy;

    
    private String performedAt;


    @PositiveOrZero(message = "Maintenance cost cannot be negative")
    private Double cost;

    
    private MaintenanceStatus status;

    @Positive(message = "Fleet Manager ID must be a positive number")
    private Long fleetManager;
}
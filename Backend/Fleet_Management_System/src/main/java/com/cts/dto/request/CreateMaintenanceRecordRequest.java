package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMaintenanceRecordRequest {

    @NotNull(message = "Vehicle ID is required")
    @Positive(message = "Vehicle ID must be a positive number")
    private Long vehicleId;

    @NotNull(message = "Fleet Manager ID is required")
    @Positive(message = "Fleet Manager ID must be a positive number")
    private Long fleetManager;

    @NotBlank(message = "Task description is required")
    @Size(min = 5, max = 500, message = "Task description must be between 5 and 500 characters")
    private String taskDescription;

    @NotBlank(message = "Performed by is required")
    @Size(min = 3, max = 100, message = "Performed by must be between 3 and 100 characters")
    private String performedBy;

    @NotBlank(message = "Performed at date-time is required")
    private String performedAt;
  

    @NotNull(message = "Maintenance cost is required")
    @PositiveOrZero(message = "Maintenance cost cannot be negative")
    private Double cost;
}

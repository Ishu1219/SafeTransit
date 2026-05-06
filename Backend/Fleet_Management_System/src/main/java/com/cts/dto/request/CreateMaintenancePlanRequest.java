package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMaintenancePlanRequest {

    @NotNull(message = "Vehicle ID is required")
    @Positive(message = "Vehicle ID must be a positive number")
    private Long vehicleId;

    @NotNull(message = "Fleet Manager ID is required")
    @Positive(message = "Fleet Manager ID must be a positive number")
    private Long fleetManagerId;

    @NotNull(message = "Maintenance frequency is required")
    @Min(value = 1, message = "Frequency days must be at least 1")
    private Integer frequencyDays;

    @NotBlank(message = "Next due date is required")
    private String nextDueDate;
  
}

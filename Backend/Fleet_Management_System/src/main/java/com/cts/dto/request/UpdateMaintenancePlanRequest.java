package com.cts.dto.request;

import com.cts.enums.MaintenancePlanStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMaintenancePlanRequest {

    @Positive(message = "Vehicle ID must be a positive number")
    private Long vehicleId;

    @Min(value = 1, message = "Frequency days must be at least 1")
    private Integer frequencyDays;

    @Pattern(
        regexp = "^\\d{4}-\\d{2}-\\d{2}$",
        message = "Next due date must be in ISO format yyyy-MM-dd"
    )
    private String nextDueDate;
    

    
    private MaintenancePlanStatus status;
}

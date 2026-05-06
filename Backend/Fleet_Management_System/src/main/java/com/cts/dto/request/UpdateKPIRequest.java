package com.cts.dto.request;

import com.cts.enums.ReportingPeriod;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateKPIRequest {

    @Size(min = 3, max = 100, message = "KPI name must be between 3 and 100 characters")
    private String name;

    @Size(min = 10, max = 500, message = "KPI definition must be between 10 and 500 characters")
    private String definition;

    @Positive(message = "Target value must be greater than zero")
    private Double target;

    @PositiveOrZero(message = "Current value cannot be negative")
    private Double currentValue;

    
    private ReportingPeriod reportingPeriod;

    @Positive(message = "Operations Manager ID must be a positive number")
    private Long operationsManagerId;
}
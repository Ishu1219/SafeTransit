package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePassengerReportRequest {

    @Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters")
    private String description;

    
    private String category;

    
    private String status;

    @Positive(message = "Schedule ID must be a positive number")
    private Long scheduleId;
}
package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRouteScheduleRequest {

    @Pattern(
        regexp = "^\\d{4}-\\d{2}-\\d{2}$",
        message = "Schedule date must be in ISO format yyyy-MM-dd"
    )
    private String scheduleDate;

    
    private String startTime;

   
    private String endTime;

    
    private String status;
}

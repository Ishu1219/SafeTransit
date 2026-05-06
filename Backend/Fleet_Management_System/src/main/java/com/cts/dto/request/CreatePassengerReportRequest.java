package com.cts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePassengerReportRequest{
	@NotBlank(message = "Description is required")
    @Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters")
    private String description;
	@NotBlank(message = "Category is Required")
    private String category;
	@NotNull(message = "ScheduleId is required")
	@Positive(message = "ScheduleId must be a positive number")
	private Long scheduleId;

}
package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInspectionRecordRequest {

    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

    @NotNull(message = "Inspection date is required")
    @PastOrPresent(message = "Inspection date cannot be in the future")
    private LocalDate performedAt;

    @NotNull(message = "Condition rating is required")
    @Min(value = 1, message = "Condition rating must be at least 1")
    @Max(value = 5, message = "Condition rating must be at most 5")
    private Integer conditionRating;  

    @NotBlank(message = "Findings are required")
    @Size(max = 500, message = "Findings must not exceed 500 characters")
    private String findings;

}
package com.cts.dto.request;

import java.time.LocalDate;

import com.cts.enums.InspectionRecordStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInspectionRecordRequest {

    @PastOrPresent(message = "Performed date cannot be in the future")
    private LocalDate performedAt;

    @Min(value = 1, message = "Condition rating must be at least 1")
    @Max(value = 5, message = "Condition rating must be at most 5")
    private Integer conditionRating;

    @Size(min = 5, max = 1000, message = "Findings must be between 5 and 1000 characters")
    private String findings;

    private InspectionRecordStatus status;
}
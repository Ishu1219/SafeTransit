package com.cts.dto.response;

import lombok.*;
import java.time.Instant;
import java.time.LocalDate;

import com.cts.enums.InspectionRecordStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InspectionRecordResponse {
    private Long inspectionId;
    private String inspectorName;
    private Long vehicleId;
    private Long inspectorId;
    private LocalDate performedAt;
    private Integer conditionRating;
    
    private String findings;
    @Enumerated(EnumType.STRING)
    private InspectionRecordStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}

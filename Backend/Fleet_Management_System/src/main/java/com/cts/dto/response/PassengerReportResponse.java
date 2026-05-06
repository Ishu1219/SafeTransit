package com.cts.dto.response;

import lombok.*;
import java.time.LocalDateTime;

import com.cts.enums.AuditAction;
import com.cts.enums.Sex;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerReportResponse {

    private Long reportId;
    private Long passengerId;
    private String description;
    private String category;
    private AuditAction status;
    private Long scheduleId; 
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
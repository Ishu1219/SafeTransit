package com.cts.dto.response;

import com.cts.enums.ReportingPeriod;
import lombok.*;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KPIResponse {
    private Long kpiId;
    private String name;
    private String definition;
    private Double target;
    private Double currentValue;
    private ReportingPeriod reportingPeriod;
    private Long operationsManagerId;
    private Instant createdAt;
    private Instant updatedAt;
}
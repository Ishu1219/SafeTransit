package com.cts.dto.response;

import java.time.Instant;

import com.cts.enums.ComplainceOfficer;
import com.cts.enums.Sex;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceOfficerResponse {
    private Long officerId;
    private String name;
    private String email;
    private String phone;
    private Sex sex; 
    private ComplainceOfficer status;
    private Instant createdAt;
    private Instant updatedAt;
}

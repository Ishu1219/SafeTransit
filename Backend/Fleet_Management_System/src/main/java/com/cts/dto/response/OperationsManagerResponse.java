package com.cts.dto.response;

import com.cts.enums.OperationsManagerStatus;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationsManagerResponse {

    private Long operationsManagerId;
    private String name;
    private String email;
    private String phone;
    private String emergencyContact;
    private String address;
    private String bloodGroup;
    private OperationsManagerStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
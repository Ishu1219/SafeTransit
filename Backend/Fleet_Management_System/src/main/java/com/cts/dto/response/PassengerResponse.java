package com.cts.dto.response;

import lombok.*;

import java.time.Instant;
//import java.time.LocalDate;

import com.cts.enums.AuditAction;
import com.cts.enums.Sex;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerResponse {

    private Long passengerId;
    private String name;
    private String email;
    private String phone;
    private AuditAction status;
    private Sex sex;
    private Instant createdAt;
    private Instant updatedAt;
}
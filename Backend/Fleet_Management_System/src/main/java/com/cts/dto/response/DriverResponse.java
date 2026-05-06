package com.cts.dto.response;
 
import com.cts.enums.DriverStatus;
import com.cts.enums.Sex;

import lombok.*;
 
import java.time.Instant;
 
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponse {
 
    private Long driverId;
    private String name;
    private String email;
    private String phone;
    private String licence;
    private String emergencyContact;
    private String address;
    private String bloodGroup;
    private DriverStatus status;
    private Instant createdAt;
    private Instant updatedAt;
    private Sex sex;
}
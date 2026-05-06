package com.cts.dto.response;

import lombok.*;
import java.time.Instant;
import com.cts.enums.FleetManagerStatus;
import com.cts.enums.Sex;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FleetManagerResponse {

    private Long fleetManagerId;
    private String name;
    private String email;
    private String phone;
    private String emergencyContact;
    private String address;
    private String bloodGroup;
    private Sex sex;                       
    private FleetManagerStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
package com.cts.dto.response;

import com.cts.enums.VehicleStatus;
import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleResponse {
    private Long vehicleId;
    private String regNumber;
    private Integer capacity;
    private String model;
    private String manufacturer;
    private String yearOfManufacture;
    private String fuelType;
    private VehicleStatus status;  
    private Instant createdAt;
    private Instant updatedAt;
}
package com.cts.dto.request;

import com.cts.enums.VehicleStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateVehicleRequest {

    @Size(min = 5, max = 20, message = "Registration number must be between 5 and 20 characters")
    
    private String regNumber;

    @Positive(message = "Vehicle capacity must be greater than zero")
    private Integer capacity;

    @Size(min = 2, max = 100, message = "Model must be between 2 and 100 characters")
    private String model;

    @Size(min = 2, max = 100, message = "Manufacturer must be between 2 and 100 characters")
    private String manufacturer;

    private String yearOfManufacture;

    @Size(min = 3, max = 50, message = "Fuel type must be between 3 and 50 characters")
    private String fuelType;

    
    private VehicleStatus status;
}
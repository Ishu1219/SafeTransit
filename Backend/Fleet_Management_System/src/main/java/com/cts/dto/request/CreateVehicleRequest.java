package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVehicleRequest {

    @NotBlank(message = "Registration number is required")
    @Size(min = 5, max = 20, message = "Registration number must be between 5 and 20 characters")
    private String regNumber;

    @NotNull(message = "Vehicle capacity is required")
    @Positive(message = "Vehicle capacity must be greater than zero")
    private Integer capacity;

    @NotBlank(message = "Vehicle model is required")
    @Size(min = 2, max = 100, message = "Vehicle model must be between 2 and 100 characters")
    private String model;

    @NotBlank(message = "Manufacturer name is required")
    @Size(min = 2, max = 100, message = "Manufacturer name must be between 2 and 100 characters")
    private String manufacturer;

    @NotBlank(message = "Year of manufacture is required")
    private String yearOfManufacture;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;
}

package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOperationsManagerRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @NotBlank(message = "Emergency contact is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Emergency contact must be a valid 10-digit phone number"
    )
    private String emergencyContact;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 300, message = "Address must be between 10 and 300 characters")
    private String address;

    @NotBlank(message = "Blood group is required")
    private String bloodGroup;
}
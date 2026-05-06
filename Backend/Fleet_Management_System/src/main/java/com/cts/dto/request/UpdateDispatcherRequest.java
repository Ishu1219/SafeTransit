package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDispatcherRequest {

    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Phone must be a valid 10-digit Indian number"
    )
    private String phone;

    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Emergency contact must be a valid 10-digit number"
    )
    private String emergencyContact;

    @Size(max = 100, message = "Address must not exceed 100 characters")
    private String address;

    
    private String bloodGroup;

    
    private String status;

    
    private String sex;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}
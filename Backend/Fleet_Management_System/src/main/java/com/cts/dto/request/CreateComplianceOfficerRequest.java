package com.cts.dto.request;

import com.cts.enums.Sex; 

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateComplianceOfficerRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Phone must be a valid 10-digit Indian number"
    )
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

   
    private String bloodgroup;

    @Size(max = 100, message = "Address must not exceed 100 characters")
    private String address;

    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Emergency contact must be a valid 10-digit Indian number"
    )
    private String emergencycontact;
    @NotNull(message = "Sex is required")
    private Sex sex;
}
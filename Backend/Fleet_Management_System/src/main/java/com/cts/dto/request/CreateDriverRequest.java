package com.cts.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDriverRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Phone must be a valid 10-digit Indian number"
    )
    private String phone;

    @NotBlank(message = "Licence number is required")
    @Size(min = 5, max = 20, message = "Licence number must be between 5 and 20 characters")
    private String licence;

    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Emergency contact must be a valid 10-digit number"
    )
    private String emergencyContact;

    @Size(max = 100, message = "Address must not exceed 100 characters")
    private String address;

    @NotBlank(message = "Bloodgroup is required")
    private String bloodGroup;

    @NotBlank(message = "Sex is required")
    private String sex;
}

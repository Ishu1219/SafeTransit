package com.cts.dto.request;

import com.cts.enums.OperationsManagerStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOperationsManagerRequest {

    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @Email(message = "Email must be a valid email address")
    private String email;

    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Emergency contact must be a valid 10-digit phone number"
    )
    private String emergencyContact;

    @Size(min = 10, max = 300, message = "Address must be between 10 and 300 characters")
    private String address;

    private String bloodGroup;

    private OperationsManagerStatus status;
}
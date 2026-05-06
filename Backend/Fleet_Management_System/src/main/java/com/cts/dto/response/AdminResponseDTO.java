package com.cts.dto.response;

import java.time.LocalDate;
import com.cts.enums.Sex;
import lombok.Data;

@Data
public class AdminResponseDTO {
    private Long adminId;
    private String name;
    private String email;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String phone;
    private String emergencyContact;
    private String address;
    private String bloodGroup;
    private String status;
    private Sex sex;
}
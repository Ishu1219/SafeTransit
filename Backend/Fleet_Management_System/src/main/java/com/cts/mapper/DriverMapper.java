package com.cts.mapper;
 
import com.cts.dto.request.CreateDriverRequest;
import com.cts.dto.response.DriverResponse;
import com.cts.entity.Driver;
import com.cts.entity.User;
import com.cts.enums.DriverStatus;
import com.cts.enums.Sex;
 
public class DriverMapper {
 
   
    public static Driver toEntity(CreateDriverRequest req,User user) {
 
        return Driver.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .phone(req.getPhone())
                .licence(req.getLicence())
                .emergencyContact(req.getEmergencyContact())
                .address(req.getAddress())
                .bloodGroup(req.getBloodGroup())
                .sex(Sex.valueOf(req.getSex().toUpperCase()))
                .status(DriverStatus.ACTIVE) // ✅ default enum
                .user(user)
                .build();
    }
 
    public static DriverResponse toResponse(Driver d) {
 
        return DriverResponse.builder()
                .driverId(d.getDriverId())
                .name(d.getName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .licence(d.getLicence())
                .emergencyContact(d.getEmergencyContact())
                .address(d.getAddress())
                .bloodGroup(d.getBloodGroup())
                .status(d.getStatus())
                .createdAt(d.getCreatedAt())
                .updatedAt(d.getUpdatedAt())
                .sex(d.getSex())
                .build();
    }
}
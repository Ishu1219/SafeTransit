package com.cts.mapper;

import com.cts.dto.request.CreatePassengerRequest;
import com.cts.dto.response.PassengerResponse;
import com.cts.entity.Passenger;
import com.cts.entity.User;
import com.cts.enums.AuditAction;
//import com.cts.enums.UserStatus;
import com.cts.enums.Sex;

public class PassengerMapper {

    
    public static Passenger toEntity(CreatePassengerRequest request, User user) {
        return Passenger.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .sex(Sex.valueOf(request.getSex().toUpperCase()))
                .status(AuditAction.ACTIVE)  
                .user(user)                   
                .build();
    }
	

   
    public static PassengerResponse toResponse(Passenger p) {
        return PassengerResponse.builder()
                .passengerId(p.getPassengerId())
                .name(p.getName())
                .email(p.getEmail())
                .phone(p.getPhone())
                .sex(p.getSex())
                .status(p.getStatus())
                .createdAt(p.getCreatedAt())
                .updatedAt(p.getUpdatedAt())
                .build();
    }
}
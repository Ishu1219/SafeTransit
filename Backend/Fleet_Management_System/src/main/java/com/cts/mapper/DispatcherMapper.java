package com.cts.mapper;

import com.cts.dto.request.CreateDispatcherRequest;
import com.cts.dto.response.DispatcherResponse;
import com.cts.entity.Dispatcher;
import com.cts.entity.User;
import com.cts.enums.AuditAction;
import com.cts.enums.Sex;

public class DispatcherMapper {

    public static Dispatcher toEntity(CreateDispatcherRequest req,User user) {
        return Dispatcher.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .phone(req.getPhone())
                .emergencyContact(req.getEmergencyContact())
                .address(req.getAddress())
                .bloodGroup(req.getBloodGroup())
                .sex(Sex.valueOf(req.getSex().toUpperCase()))
                .status(AuditAction.ACTIVE)
                .user(user)
                .build();
    }

    public static DispatcherResponse toResponse(Dispatcher d) {
        return DispatcherResponse.builder()
                .dispatcherId(d.getDispatcherId())
                .name(d.getName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .emergencyContact(d.getEmergencyContact())
                .address(d.getAddress())
                .bloodGroup(d.getBloodGroup())
                .status(d.getStatus())
                .sex(d.getSex())
                .createdAt(d.getCreatedAt())
                .updatedAt(d.getUpdatedAt())
                .build();
    }
}
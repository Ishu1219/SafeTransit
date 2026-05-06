package com.cts.mapper;

import com.cts.dto.request.CreateOperationsManagerRequest;
import com.cts.dto.request.UpdateOperationsManagerRequest;
import com.cts.dto.response.OperationsManagerResponse;
import com.cts.entity.OperationsManager;
import com.cts.entity.User;
import com.cts.enums.OperationsManagerStatus;

public class OperationsManagerMapper {

    public static OperationsManager toEntity(CreateOperationsManagerRequest req,User user) {

        return OperationsManager.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .phone(req.getPhone())
                .emergencyContact(req.getEmergencyContact())
                .address(req.getAddress())
                .bloodGroup(req.getBloodGroup())
                .status(OperationsManagerStatus.ACTIVE)
                .user(user)
                .build();
    }

    public static OperationsManagerResponse toResponse(OperationsManager om) {

        return OperationsManagerResponse.builder()
                .operationsManagerId(om.getOperationsManagerId())
                .name(om.getName())
                .email(om.getEmail())
                .phone(om.getPhone())
                .emergencyContact(om.getEmergencyContact())
                .address(om.getAddress())
                .bloodGroup(om.getBloodGroup())
                .status(om.getStatus())
                .createdAt(om.getCreatedAt())
                .updatedAt(om.getUpdatedAt())
                .build();
    }

    public static void updateEntity(
            OperationsManager om,
            UpdateOperationsManagerRequest req) {

        om.setName(req.getName());
        om.setEmail(req.getEmail());
        om.setPhone(req.getPhone());
        om.setEmergencyContact(req.getEmergencyContact());
        om.setAddress(req.getAddress());
        om.setBloodGroup(req.getBloodGroup());
        om.setStatus(req.getStatus());
    }
}
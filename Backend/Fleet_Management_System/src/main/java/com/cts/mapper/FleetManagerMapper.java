package com.cts.mapper;

import com.cts.dto.request.CreateFleetManagerRequest;
import com.cts.dto.request.UpdateFleetManagerRequest;
import com.cts.dto.response.FleetManagerResponse;
import com.cts.entity.FleetManager;
import com.cts.entity.User;
import com.cts.enums.FleetManagerStatus;

public class FleetManagerMapper {

	public static FleetManager toEntity(
	        CreateFleetManagerRequest req,
	        User user) {

	    return FleetManager.builder()
	            .name(req.getName())
	            .email(req.getEmail())
	            .password(req.getPassword())
	            .phone(req.getPhone())
	            .emergencyContact(req.getEmergencyContact())
	            .address(req.getAddress())
	            .bloodGroup(req.getBloodGroup())
	            .sex(req.getSex())                     
	            .status(FleetManagerStatus.ACTIVE)
	            .user(user)
	            .build();
	}

    // =========================
    // RESPONSE : ENTITY → DTO
    // =========================
    public static FleetManagerResponse toResponse(FleetManager fm) {

        return FleetManagerResponse.builder()
                .fleetManagerId(fm.getFleetManagerId())
                .name(fm.getName())
                .email(fm.getEmail())
                .phone(fm.getPhone())
                .emergencyContact(fm.getEmergencyContact())
                .address(fm.getAddress())
                .bloodGroup(fm.getBloodGroup())
                .status(fm.getStatus())
                .sex(fm.getSex())
                .createdAt(fm.getCreatedAt())
                .updatedAt(fm.getUpdatedAt())
                .build();
    }


    public static void updateEntity(
            FleetManager fm,
            UpdateFleetManagerRequest req) {

        fm.setName(req.getName());
        fm.setEmail(req.getEmail());
        fm.setPhone(req.getPhone());
        fm.setEmergencyContact(req.getEmergencyContact());
        fm.setAddress(req.getAddress());
        fm.setBloodGroup(req.getBloodGroup());
        fm.setStatus(req.getStatus());
    }
}

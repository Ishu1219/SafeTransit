package com.cts.mapper;

import com.cts.dto.request.CreateComplianceOfficerRequest;
import com.cts.dto.request.UpdateComplianceOfficerRequest;
import com.cts.dto.response.ComplianceOfficerResponse;
import com.cts.entity.ComplianceOfficer;
import com.cts.entity.User;
import com.cts.enums.ComplainceOfficer;


public class ComplianceOfficerMapper {

    public static ComplianceOfficer toEntity(CreateComplianceOfficerRequest request,User user) {
        return ComplianceOfficer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .bloodgroup(request.getBloodgroup())
                .address(request.getAddress())
                .emergencycontact(request.getEmergencycontact())
                .sex(request.getSex())
                .status(ComplainceOfficer.ACTIVE)
                .user(user)
                .build();
    }

    public static void updateEntity(ComplianceOfficer officer, UpdateComplianceOfficerRequest request) {
        officer.setName(request.getName());
        officer.setPassword(request.getPassword());
        officer.setEmail(request.getEmail());
        officer.setPhone(request.getPhone());
        officer.setBloodgroup(request.getBloodGroup());
        officer.setEmergencycontact(request.getEmergencyContact());
        officer.setStatus(ComplainceOfficer.ACTIVE);
    }

    public static ComplianceOfficerResponse toResponse(ComplianceOfficer officer) {
        return ComplianceOfficerResponse.builder()
                 .officerId(officer.getOfficerId())       
                 .name(officer.getName())
                 .email(officer.getEmail())
                 .phone(officer.getPhone())
                 .sex(officer.getSex())
                 .status(officer.getStatus())             
                 .createdAt(officer.getCreatedAt())       
                 .updatedAt(officer.getUpdatedAt())
                 .build();
    }

}

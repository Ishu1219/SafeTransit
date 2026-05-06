package com.cts.mapper;

import org.springframework.stereotype.Component; 
import com.cts.dto.request.UpdateAdminRequest;
import com.cts.dto.response.AdminResponseDTO;
import com.cts.entity.Admin;
 
@Component
public class AdminMapper {

    public void updateEntity(Admin admin, UpdateAdminRequest dto) {
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        admin.setPhone(dto.getPhone());
        admin.setEmergencyContact(dto.getEmergencyContact());
        admin.setAddress(dto.getAddress());
        admin.setBloodGroup(dto.getBloodGroup());
        admin.setSex(dto.getSex());
    }

    public AdminResponseDTO toOutputDTO(Admin admin) {
        AdminResponseDTO dto = new AdminResponseDTO();
        dto.setAdminId(admin.getAdminId());
        dto.setName(admin.getName());
        dto.setEmail(admin.getEmail());
        dto.setCreatedAt(admin.getCreatedAt());
        dto.setUpdatedAt(admin.getUpdatedAt());
        dto.setPhone(admin.getPhone());
        dto.setEmergencyContact(admin.getEmergencyContact());
        dto.setAddress(admin.getAddress());
        dto.setBloodGroup(admin.getBloodGroup());
        dto.setStatus(admin.getStatus());
        dto.setSex(admin.getSex());
        return dto;
    }
}
package com.cts.service;

import com.cts.dto.request.UpdateAdminRequest;
import com.cts.dto.response.AdminResponseDTO;

public interface AdminService {
    AdminResponseDTO getAdmin(Long adminId);
    AdminResponseDTO updateAdmin(Long adminId, UpdateAdminRequest dto);
}
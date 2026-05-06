package com.cts.service.imp;

import org.springframework.stereotype.Service;
import com.cts.dto.request.UpdateAdminRequest;
import com.cts.dto.response.AdminResponseDTO;
import com.cts.entity.Admin;
import com.cts.exception.NotExistException;
import com.cts.mapper.AdminMapper;
import com.cts.repository.AdminRepository;
import com.cts.service.AdminService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    public AdminResponseDTO getAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new NotExistException("Admin not found with id: " + adminId));
        return adminMapper.toOutputDTO(admin);
    }

    @Override
    public AdminResponseDTO updateAdmin(Long adminId, UpdateAdminRequest dto) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new NotExistException("Admin not found with id: " + adminId));
        adminMapper.updateEntity(admin, dto);
        Admin updatedAdmin = adminRepository.save(admin);
        return adminMapper.toOutputDTO(updatedAdmin);
    }
}
package com.cts.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.api.APIResponse;
import com.cts.dto.request.UpdateAdminRequest;
import com.cts.dto.response.AdminResponseDTO;
import com.cts.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/get/{adminId}")
    public ResponseEntity<APIResponse<AdminResponseDTO>> getAdmin(@PathVariable Long adminId) {
        AdminResponseDTO response = adminService.getAdmin(adminId);
        return new ResponseEntity<>(
                APIResponse.<AdminResponseDTO>builder()
                        .status("success")
                        .message("Admin fetched successfully")
                        .data(response)
                        .build(),
                HttpStatus.OK);
    }

    @PutMapping("/update/{adminId}")
    public ResponseEntity<APIResponse<AdminResponseDTO>> updateAdmin(@PathVariable Long adminId,
            @Valid @RequestBody UpdateAdminRequest dto) {
        AdminResponseDTO response = adminService.updateAdmin(adminId, dto);
        return new ResponseEntity<>(
                APIResponse.<AdminResponseDTO>builder()
                        .status("success")
                        .message("Admin updated successfully")
                        .data(response)
                        .build(),
                HttpStatus.OK);
    }
}
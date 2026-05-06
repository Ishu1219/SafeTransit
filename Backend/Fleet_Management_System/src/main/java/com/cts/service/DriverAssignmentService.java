package com.cts.service;

import com.cts.dto.request.CreateDriverAssignmentRequest;
import com.cts.dto.request.UpdateDriverAssignmentRequest;
import com.cts.dto.response.DriverAssignmentResponse;

import java.util.List;

public interface DriverAssignmentService {

    DriverAssignmentResponse createAssignment(CreateDriverAssignmentRequest request);

    DriverAssignmentResponse updateAssignment(Long assignId, UpdateDriverAssignmentRequest request);

    void deleteAssignment(Long assignId);

    DriverAssignmentResponse getAssignmentById(Long assignId);

    List<DriverAssignmentResponse> getAllAssignments();
}
package com.cts.service;

import com.cts.dto.request.CreateComplianceOfficerRequest; 
import com.cts.dto.request.UpdateComplianceOfficerRequest;
import com.cts.dto.response.ComplianceOfficerResponse;
import com.cts.entity.ComplianceOfficer;

import java.util.List;

public interface ComplianceOfficerService {

    ComplianceOfficerResponse createOfficer(CreateComplianceOfficerRequest request);

    ComplianceOfficer deleteOfficer(Long id);

    ComplianceOfficerResponse updateOfficer(Long id, UpdateComplianceOfficerRequest request);

    List<ComplianceOfficerResponse> getAllOfficers();

    ComplianceOfficerResponse getOfficerById(Long id);
}

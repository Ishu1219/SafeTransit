package com.cts.service;

import com.cts.dto.request.CreateInspectionRecordRequest;
import com.cts.dto.request.UpdateInspectionRecordRequest;
import com.cts.dto.response.InspectionRecordResponse;
import com.cts.entity.InspectionRecord;

import java.util.List;

public interface InspectionRecordService {

    InspectionRecordResponse createInspection(Long id,CreateInspectionRecordRequest request);

    InspectionRecord deleteInspection(Long id);

    InspectionRecordResponse updateInspection(Long id, UpdateInspectionRecordRequest request);

    List<InspectionRecordResponse> getAllInspections();

    InspectionRecordResponse getInspectionById(Long id);

    List<InspectionRecordResponse> getInspectionsByVehicle(Long vehicleId);

    List<InspectionRecordResponse> getInspectionsByInspector(Long inspectorId);

    List<InspectionRecordResponse> getInspectionsByStatus(String status);
}
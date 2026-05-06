package com.cts.service;

import com.cts.dto.request.CreateMaintenanceRecordRequest;
import com.cts.dto.request.UpdateMaintenanceRecordRequest;
import com.cts.dto.response.MaintenanceRecordResponse;
import com.cts.entity.MaintenanceRecord;
import java.util.List;

public interface MaintenanceRecordService {
    MaintenanceRecordResponse createMaintenanceRecord(CreateMaintenanceRecordRequest request);
    MaintenanceRecord deleteMaintenanceRecord(Long id);
    MaintenanceRecordResponse updateMaintenanceRecord(Long id, UpdateMaintenanceRecordRequest request);
    MaintenanceRecordResponse getMaintenanceRecordById(Long id);
    List<MaintenanceRecordResponse> getAllMaintenanceRecords();
    List<MaintenanceRecordResponse> getByVehicle(Long vehicleId);
    List<MaintenanceRecordResponse> getByStatus(String status);
}
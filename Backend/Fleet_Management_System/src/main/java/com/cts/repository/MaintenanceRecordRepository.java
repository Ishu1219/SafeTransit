package com.cts.repository;

import com.cts.entity.MaintenanceRecord; 
import com.cts.enums.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Long> {

    MaintenanceRecord findByMaintId(Long maintId);

    List<MaintenanceRecord> findByVehicle_VehicleId(Long vehicleId);

    List<MaintenanceRecord> findByStatus(MaintenanceStatus status);

    List<MaintenanceRecord> findByVehicle_VehicleIdAndStatus(Long vehicleId, MaintenanceStatus status);
}

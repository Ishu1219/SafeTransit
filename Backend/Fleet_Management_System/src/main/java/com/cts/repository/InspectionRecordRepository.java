package com.cts.repository;

import com.cts.entity.InspectionRecord;
import com.cts.enums.InspectionRecordStatus;
//import com.cts.enums.enums1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionRecordRepository extends JpaRepository<InspectionRecord, Long> {

    List<InspectionRecord> findByVehicleId(Long vehicleId);

    List<InspectionRecord> findByInspectorOfficerId(Long officerId);

    List<InspectionRecord> findByStatus(InspectionRecordStatus status);
}


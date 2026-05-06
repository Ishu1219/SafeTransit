package com.cts.mapper;

import com.cts.dto.request.CreateInspectionRecordRequest;
import com.cts.dto.request.UpdateInspectionRecordRequest;
import com.cts.dto.response.InspectionRecordResponse;
import com.cts.entity.ComplianceOfficer;
import com.cts.entity.InspectionRecord;
import com.cts.enums.InspectionRecordStatus;

public class InspectionRecordMapper {

   
	public static InspectionRecord toEntity(ComplianceOfficer officer, CreateInspectionRecordRequest request) {
	    return InspectionRecord.builder()
	            .vehicleId(request.getVehicleId())
	            .performedAt(request.getPerformedAt())
	            .conditionRating(request.getConditionRating())
	            .findings(request.getFindings())
	            .status(InspectionRecordStatus.SCHEDULED)
	            .inspector(officer)  
	            .build();
	}

    
    public static void updateEntity(InspectionRecord record, UpdateInspectionRecordRequest request) {
        record.setConditionRating(request.getConditionRating());
        record.setFindings(request.getFindings());
        record.setStatus(InspectionRecordStatus.IN_PROGRESS);
        record.setPerformedAt(request.getPerformedAt());
    }

   
    public static InspectionRecordResponse toResponse(InspectionRecord record) {
        return InspectionRecordResponse.builder()
                .inspectionId(record.getInspectionId())
                .inspectorName(record.getInspector().getName())
                .vehicleId(record.getVehicleId())
                .inspectorId(record.getInspector().getOfficerId()) 
                .performedAt(record.getPerformedAt())
                .conditionRating(record.getConditionRating())
                .findings(record.getFindings())
                .status(record.getStatus())
                .createdAt(record.getCreatedAt())
                .updatedAt(record.getUpdatedAt())
                .build();
    }

}

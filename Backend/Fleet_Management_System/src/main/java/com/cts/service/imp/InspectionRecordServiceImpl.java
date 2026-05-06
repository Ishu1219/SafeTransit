package com.cts.service.imp;

import com.cts.dto.request.CreateInspectionRecordRequest;
import com.cts.dto.request.UpdateInspectionRecordRequest;
import com.cts.dto.response.InspectionRecordResponse;
import com.cts.entity.ComplianceOfficer;
import com.cts.entity.InspectionRecord;
import com.cts.entity.Vehicle;
import com.cts.enums.InspectionRecordStatus;
import com.cts.exception.NotExistException;
import com.cts.mapper.InspectionRecordMapper;
import com.cts.repository.ComplianceOfficerRepository;
import com.cts.repository.InspectionRecordRepository;
import com.cts.repository.VehicleRepository;
import com.cts.service.InspectionRecordService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InspectionRecordServiceImpl implements InspectionRecordService {

    private final InspectionRecordRepository inspectionRecordRepository;
    private final ComplianceOfficerRepository complianceOfficerRepository;
    private final VehicleRepository vehicleRepository;
  
    @Override
    public InspectionRecordResponse createInspection(Long officerId, CreateInspectionRecordRequest request) {
        ComplianceOfficer officer = complianceOfficerRepository.findById(officerId)
                .orElseThrow(() -> new NotExistException("Compliance Officer not found with id: " + officerId));
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found"));
        InspectionRecord record = InspectionRecordMapper.toEntity(officer, request);
        InspectionRecord saved = inspectionRecordRepository.save(record);

        return InspectionRecordMapper.toResponse(saved);
    }

  
    @Override
    public InspectionRecord deleteInspection(Long id) {
        InspectionRecord existing = inspectionRecordRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Inspection record not found with id: " + id));

        inspectionRecordRepository.deleteById(id);
        return existing;
    }

   
    @Override
    public InspectionRecordResponse updateInspection(
            Long id, UpdateInspectionRecordRequest request) {

        InspectionRecord record = inspectionRecordRepository.findById(id)
                .orElseThrow(() ->
                        new NotExistException("Inspection record not found with id: " + id));

        if (request.getPerformedAt() != null) {
            record.setPerformedAt(request.getPerformedAt());
        }

        if (request.getConditionRating() != null) {
            record.setConditionRating(request.getConditionRating());
        }

        if (request.getFindings() != null) {
            record.setFindings(request.getFindings());
        }

        if (request.getStatus() != null) {
            record.setStatus(request.getStatus());
        }

        InspectionRecord updated = inspectionRecordRepository.save(record);

        return InspectionRecordMapper.toResponse(updated);
    }
    
    @Override
    public List<InspectionRecordResponse> getAllInspections() {
        return inspectionRecordRepository.findAll()
                .stream()
                .map(InspectionRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

  
    @Override
    public InspectionRecordResponse getInspectionById(Long id) {
        InspectionRecord record = inspectionRecordRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Inspection record not found with id: " + id));

        return InspectionRecordMapper.toResponse(record);
    }

   
    @Override
    public List<InspectionRecordResponse> getInspectionsByVehicle(Long vehicleId) {
        return inspectionRecordRepository.findByVehicleId(vehicleId)
                .stream()
                .map(InspectionRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

  
    @Override
    public List<InspectionRecordResponse> getInspectionsByInspector(Long officerId) {
        return inspectionRecordRepository.findByInspectorOfficerId(officerId)
                .stream()
                .map(InspectionRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

    
    @Override
	public List<InspectionRecordResponse> getInspectionsByStatus(String status) {
	    
	    InspectionRecordStatus recordStatus = InspectionRecordStatus.valueOf(status.toUpperCase());
	   
	    return inspectionRecordRepository.findByStatus(recordStatus)
	            .stream()
	            .map(InspectionRecordMapper::toResponse)
	            .collect(Collectors.toList());
	}
 
 
    
}

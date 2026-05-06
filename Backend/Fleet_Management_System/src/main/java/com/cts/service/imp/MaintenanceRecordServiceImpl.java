package com.cts.service.imp;

import com.cts.dto.request.CreateMaintenanceRecordRequest; 
import com.cts.dto.request.UpdateMaintenanceRecordRequest;
import com.cts.dto.response.MaintenanceRecordResponse;
import com.cts.entity.FleetManager;
import com.cts.entity.MaintenanceRecord;
import com.cts.entity.Vehicle;
import com.cts.enums.MaintenanceStatus;
import com.cts.exception.NotExistException;
import com.cts.mapper.MaintenanceRecordMapper;
import com.cts.repository.FleetManagerRepository;
import com.cts.repository.MaintenanceRecordRepository;
import com.cts.repository.VehicleRepository;
import com.cts.service.MaintenanceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRepository;
    private final VehicleRepository vehicleRepository;
    private final FleetManagerRepository fleetManagerRepository;

    @Override
    public MaintenanceRecordResponse createMaintenanceRecord(CreateMaintenanceRecordRequest request) {
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + request.getVehicleId()));
        FleetManager fleetmanager=fleetManagerRepository.findById(request.getFleetManager())
        		.orElseThrow(()->new NotExistException("FleetManager not found with id: " + request.getFleetManager()));
        Instant performedAt;

	    if (request.getPerformedAt() != null) {
	   
	        LocalDate date = LocalDate.parse(request.getPerformedAt());
	        performedAt = date.atStartOfDay(ZoneOffset.UTC).toInstant();
	    } else {
	      
	        performedAt = Instant.now();
	    }
	    
        MaintenanceRecord record = MaintenanceRecord.builder()
                .vehicle(vehicle)
                .taskDescription(request.getTaskDescription())
                .performedBy(request.getPerformedBy())
                .performedAt(performedAt)
                .cost(request.getCost())
                .status(MaintenanceStatus.SCHEDULED)
                .fleetManager(fleetmanager)
                .build();

        MaintenanceRecord saved = maintenanceRepository.save(record);
        return MaintenanceRecordMapper.toResponse(saved);
    }

    @Override
    public MaintenanceRecord deleteMaintenanceRecord(Long id) {
        MaintenanceRecord existing = maintenanceRepository.findByMaintId(id);
        if (existing == null) {
            throw new NotExistException("Maintenance record not found with id: " + id);
        }
        maintenanceRepository.deleteById(id);
        return existing;
    }

    @Override
    public MaintenanceRecordResponse updateMaintenanceRecord(Long id, UpdateMaintenanceRecordRequest request) {
        MaintenanceRecord record = maintenanceRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Maintenance record not found with id: " + id));

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + request.getVehicleId()));
        Instant performedAt;

	    if (request.getPerformedAt() != null) {
	       
	        LocalDate date = LocalDate.parse(request.getPerformedAt());
	        performedAt = date.atStartOfDay(ZoneOffset.UTC).toInstant();
	    } else {
	      
	        performedAt = Instant.now();
	    }
	 
	   if(record.getVehicle()!=null)
	    record.setVehicle(vehicle);

	   if(request.getTaskDescription()!=null)
	    record.setTaskDescription(request.getTaskDescription());

	  
	    if (request.getPerformedBy() != null) {
	        record.setPerformedBy(request.getPerformedBy());
	    }
	    if(request.getFleetManager()!=null) {
	    	FleetManager fleetmanager=fleetManagerRepository.findById(request.getFleetManager())
	        		.orElseThrow(()->new NotExistException("FleetManager not found with id: " + request.getFleetManager()));
	    	
	    	record.setFleetManager(fleetmanager);
	    }
	   

	    if (performedAt != null) {
	        record.setPerformedAt(performedAt);
	    }

	    if (request.getCost() != null) {
	        record.setCost(request.getCost());
	    }

	  
	    if (request.getStatus() != null) {
	        record.setStatus(request.getStatus());
	    }
        MaintenanceRecord updated = maintenanceRepository.save(record);
        return MaintenanceRecordMapper.toResponse(updated);
    }

    @Override
    public MaintenanceRecordResponse getMaintenanceRecordById(Long id) {
        MaintenanceRecord record = maintenanceRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Maintenance record not found with id: " + id));
        return MaintenanceRecordMapper.toResponse(record);
    }

    @Override
    public List<MaintenanceRecordResponse> getAllMaintenanceRecords() {
        return maintenanceRepository.findAll()
                .stream()
                .map(MaintenanceRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaintenanceRecordResponse> getByVehicle(Long vehicleId) {
        return maintenanceRepository.findByVehicle_VehicleId(vehicleId)
                .stream()
                .map(MaintenanceRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaintenanceRecordResponse> getByStatus(String status) {
        MaintenanceStatus maintenanceStatus = MaintenanceStatus.valueOf(status.toUpperCase());
        return maintenanceRepository.findByStatus(maintenanceStatus)
                .stream()
                .map(MaintenanceRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

   
}
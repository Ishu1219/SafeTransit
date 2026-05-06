package com.cts.service.imp;

import com.cts.dto.request.CreateMaintenancePlanRequest; 
import com.cts.dto.request.UpdateMaintenancePlanRequest;
import com.cts.dto.response.MaintenancePlanResponse;
import com.cts.entity.FleetManager;
import com.cts.entity.MaintenancePlan;
import com.cts.entity.Vehicle;
import com.cts.enums.MaintenancePlanStatus;
import com.cts.exception.NotExistException;
import com.cts.mapper.MaintenancePlanMapper;
import com.cts.repository.FleetManagerRepository;
import com.cts.repository.MaintenancePlanRepository;
import com.cts.repository.VehicleRepository;
import com.cts.service.MaintenancePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaintenancePlanServiceImpl implements MaintenancePlanService {

    private final MaintenancePlanRepository planRepository;
    private final VehicleRepository vehicleRepository;
    private final FleetManagerRepository fleetManagerRepository;
    @Override
    public MaintenancePlanResponse createPlan(CreateMaintenancePlanRequest request) {
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + request.getVehicleId()));
        
        FleetManager fleetManager = fleetManagerRepository.findById(request.getFleetManagerId())
                .orElseThrow(() -> new NotExistException("Fleet Manager not found with id: " + request.getFleetManagerId()));
        
        MaintenancePlan plan = MaintenancePlan.builder()
                .vehicle(vehicle)
                .frequencyDays(request.getFrequencyDays())
                .nextDueDate(LocalDate.parse(request.getNextDueDate()))
                .status(MaintenancePlanStatus.ACTIVE)
                .fleetManager(fleetManager)
                .build();

        MaintenancePlan saved = planRepository.save(plan);
        
        return MaintenancePlanMapper.toResponse(saved);
    }

    @Override
    public MaintenancePlan deletePlan(Long id) {
        MaintenancePlan existing = planRepository.findByPlanId(id);
        if (existing == null) {
            throw new NotExistException("Maintenance plan not found with id: " + id);
        }
        planRepository.deleteById(id);
        return existing;
    }

    @Override
    public MaintenancePlanResponse updatePlan(Long id, UpdateMaintenancePlanRequest request) {
        MaintenancePlan plan = planRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Maintenance plan not found with id: " + id));

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + request.getVehicleId()));

        

        if (request.getFrequencyDays() != null) {
            plan.setFrequencyDays(request.getFrequencyDays());
        }

 
        if (request.getNextDueDate() != null) {
            plan.setNextDueDate(LocalDate.parse(request.getNextDueDate()));
        }

        if (request.getStatus() != null) {
            plan.setStatus(request.getStatus());
        }

        MaintenancePlan updated = planRepository.save(plan);
        return MaintenancePlanMapper.toResponse(updated);
    }

    @Override
    public MaintenancePlanResponse getPlanById(Long id) {
        MaintenancePlan plan = planRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Maintenance plan not found with id: " + id));
        return MaintenancePlanMapper.toResponse(plan);
    }

    @Override
    public List<MaintenancePlanResponse> getAllPlans() {
        return planRepository.findAll()
                .stream()
                .map(MaintenancePlanMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaintenancePlanResponse> getByVehicle(Long vehicleId) {
        return planRepository.findByVehicle_VehicleId(vehicleId)
                .stream()
                .map(MaintenancePlanMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaintenancePlanResponse> getByStatus(String status) {
        MaintenancePlanStatus planStatus = MaintenancePlanStatus.valueOf(status.toUpperCase());
        return planRepository.findByStatus(planStatus)
                .stream()
                .map(MaintenancePlanMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaintenancePlanResponse> getOverduePlans() {
       
        return planRepository.findByNextDueDateLessThanEqualAndStatus(
                        LocalDate.now(), MaintenancePlanStatus.ACTIVE)
                .stream()
                .map(MaintenancePlanMapper::toResponse)
                .collect(Collectors.toList());
    }
}
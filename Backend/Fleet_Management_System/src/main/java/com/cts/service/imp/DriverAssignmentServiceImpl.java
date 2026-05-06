package com.cts.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.dto.request.CreateDriverAssignmentRequest;
import com.cts.dto.request.UpdateDriverAssignmentRequest;
import com.cts.dto.response.DriverAssignmentResponse;
import com.cts.entity.Dispatcher;
import com.cts.entity.Driver;
import com.cts.entity.DriverAssignment;
import com.cts.entity.Route;
import com.cts.entity.Vehicle;
import com.cts.enums.DriverAssignmentStatus;
import com.cts.exception.NotExistException;
import com.cts.mapper.DriverAssignmentMapper;
import com.cts.repository.DispatcherRepository;
import com.cts.repository.DriverAssignmentRepository;
import com.cts.repository.DriverRepository;
import com.cts.repository.RouteRepository;
import com.cts.repository.VehicleRepository;
import com.cts.service.DriverAssignmentService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverAssignmentServiceImpl implements DriverAssignmentService {

    private final DriverAssignmentRepository assignmentRepo;
    private final DriverRepository driverRepo;
    private final VehicleRepository vehicleRepo;
    private final RouteRepository routeRepo;
    private final DispatcherRepository dispatcherRepo;

    @Override
    public DriverAssignmentResponse createAssignment(CreateDriverAssignmentRequest request) {

        Driver driver = driverRepo.findById(request.getDriverId())
                .orElseThrow(() -> new NotExistException("Driver not found"));

        Vehicle vehicle = vehicleRepo.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found"));

        Route route = routeRepo.findById(request.getRouteId())
                .orElseThrow(() -> new NotExistException("Route not found"));

        Dispatcher dispatcher = dispatcherRepo.findById(request.getDispatcherId())
                .orElseThrow(() -> new NotExistException("Dispatcher not found"));

        DriverAssignment assignment =
                DriverAssignmentMapper.toEntity(request, driver, vehicle, route, dispatcher);

        return DriverAssignmentMapper.toResponse(
                assignmentRepo.save(assignment)
        );
    }

    @Override
    @Transactional
    public DriverAssignmentResponse updateAssignment(
            Long id,
            UpdateDriverAssignmentRequest request) {

        DriverAssignment assignment = assignmentRepo.findById(id)
                .orElseThrow(() -> new NotExistException("Assignment not found"));

        if (request.getDriverId() != null) {
            Driver driver = driverRepo.findById(request.getDriverId())
                    .orElseThrow(() ->
                            new NotExistException("Driver not found with id: " + request.getDriverId()));
            assignment.setDriver(driver);
        }

        if (request.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepo.findById(request.getVehicleId())
                    .orElseThrow(() ->
                            new NotExistException("Vehicle not found with id: " + request.getVehicleId()));
            assignment.setVehicle(vehicle);
        }

        if (request.getRouteId() != null) {
            Route route = routeRepo.findById(request.getRouteId())
                    .orElseThrow(() ->
                            new NotExistException("Route not found with id: " + request.getRouteId()));
            assignment.setRoute(route);
        }
        if(request.getDispatcherId()!=null) {
        	Dispatcher dispatcher=dispatcherRepo.findById(request.getDispatcherId())
        	.orElseThrow(()->new NotExistException("Dispatcher Not Found"));
        	assignment.setAssignedBy(dispatcher);
        }
   
        if (request.getStatus() != null) {
            assignment.setStatus(
                    DriverAssignmentStatus.valueOf(request.getStatus().toUpperCase()));
        }

        DriverAssignment updated = assignmentRepo.save(assignment);

        return DriverAssignmentMapper.toResponse(updated);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepo.deleteById(id);
    }

    @Override
    public DriverAssignmentResponse getAssignmentById(Long id) {
        return assignmentRepo.findById(id)
                .map(DriverAssignmentMapper::toResponse)
                .orElseThrow(() -> new NotExistException("Assignment not found"));
    }

    @Override
    public List<DriverAssignmentResponse> getAllAssignments() {
        return assignmentRepo.findAll()
                .stream()
                .map(DriverAssignmentMapper::toResponse)
                .toList();
    }
}
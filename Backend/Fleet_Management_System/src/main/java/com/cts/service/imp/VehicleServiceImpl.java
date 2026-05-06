package com.cts.service.imp;

import com.cts.dto.request.CreateVehicleRequest;
import com.cts.dto.request.UpdateVehicleRequest;
import com.cts.dto.response.VehicleResponse;
import com.cts.entity.Vehicle;
import com.cts.enums.VehicleStatus;
import com.cts.exception.AlreadyExistException;
import com.cts.exception.NotExistException;
import com.cts.mapper.VehicleMapper;
import com.cts.repository.VehicleRepository;
import com.cts.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleResponse createVehicle(CreateVehicleRequest request) {
        Vehicle existing = vehicleRepository.findByRegNumber(request.getRegNumber());
        if (existing != null) {
            throw new AlreadyExistException("Vehicle already exists with reg number: " + request.getRegNumber());
        }
        Vehicle vehicle = VehicleMapper.toEntity(request);
        Vehicle saved = vehicleRepository.save(vehicle);
        return VehicleMapper.toResponse(saved);
    }

    @Override
    public Vehicle deleteVehicle(Long id) {
        Vehicle existing = vehicleRepository.findByVehicleId(id);
        if (existing == null) {
            throw new NotExistException("Vehicle does not exist with id: " + id);
        }
        vehicleRepository.deleteById(id);
        return existing;
    }

    @Override
    public VehicleResponse updateVehicle(Long id, UpdateVehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + id));
        if (request.getRegNumber() != null) {
            vehicle.setRegNumber(request.getRegNumber());
        }

        if (request.getCapacity() != null) {
            vehicle.setCapacity(request.getCapacity());
        }

        if (request.getModel() != null) {
            vehicle.setModel(request.getModel());
        }

        if (request.getManufacturer() != null) {
            vehicle.setManufacturer(request.getManufacturer());
        }

        if (request.getYearOfManufacture() != null) {
            vehicle.setYearOfManufacture(request.getYearOfManufacture());
        }

        if (request.getFuelType() != null) {
            vehicle.setFuelType(request.getFuelType());
        }

        if (request.getStatus() != null) {
            vehicle.setStatus(request.getStatus());
        }
        Vehicle updated = vehicleRepository.save(vehicle);
        return VehicleMapper.toResponse(updated);
    }

    @Override
    public VehicleResponse getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + id));
        return VehicleMapper.toResponse(vehicle);
    }

    @Override
    public List<VehicleResponse> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponse> getVehiclesByStatus(String status) {
        VehicleStatus vehicleStatus = VehicleStatus.valueOf(status.toUpperCase());
        return vehicleRepository.findByStatus(vehicleStatus)
                .stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }
}

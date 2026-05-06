package com.cts.repository;

import com.cts.entity.Vehicle;
import com.cts.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByRegNumber(String regNumber);

    Vehicle findByVehicleId(Long vehicleId);

    List<Vehicle> findByStatus(VehicleStatus status);
}
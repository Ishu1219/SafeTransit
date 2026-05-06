package com.cts.repository;

import com.cts.entity.MaintenancePlan; 
import com.cts.enums.MaintenancePlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan, Long> {

    MaintenancePlan findByPlanId(Long planId);

    List<MaintenancePlan> findByVehicle_VehicleId(Long vehicleId);

    List<MaintenancePlan> findByStatus(MaintenancePlanStatus status);

   
    List<MaintenancePlan> findByNextDueDateLessThanEqualAndStatus(
            LocalDate date, MaintenancePlanStatus status);
}
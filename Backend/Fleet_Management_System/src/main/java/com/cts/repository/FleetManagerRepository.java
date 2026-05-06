package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.cts.entity.FleetManager;

public interface FleetManagerRepository extends JpaRepository<FleetManager, Long> {

    FleetManager findByEmail(String email);

    FleetManager findByFleetManagerId(Long id);
}
package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByEmail(String email);

    Driver findByDriverId(Long id);
}

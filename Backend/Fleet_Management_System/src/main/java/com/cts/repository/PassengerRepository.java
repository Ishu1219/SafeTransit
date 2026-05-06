package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Long>{
	Passenger findByEmail(String name);
	Passenger findByPassengerId(Long id);
}

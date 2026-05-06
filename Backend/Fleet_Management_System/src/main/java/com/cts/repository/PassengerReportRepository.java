package com.cts.repository;

import com.cts.entity.PassengerReport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerReportRepository extends JpaRepository<PassengerReport, Long> {
	List<PassengerReport> findByPassenger_PassengerId(Long passengerId);
}
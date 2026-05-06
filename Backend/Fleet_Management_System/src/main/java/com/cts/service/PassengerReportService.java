package com.cts.service;

import java.util.List;

import com.cts.dto.request.CreatePassengerReportRequest;
import com.cts.dto.request.UpdatePassengerReportRequest;
import com.cts.dto.response.PassengerReportResponse;

public interface PassengerReportService {

	PassengerReportResponse createReport(Long passengerId, CreatePassengerReportRequest request);
	PassengerReportResponse updateReport(Long reportId, Long passengerId, UpdatePassengerReportRequest request);
	PassengerReportResponse getReportById(Long reportId);
	List<PassengerReportResponse> getAllReports();
	List<PassengerReportResponse> getReportsByPassengerId(Long passengerId);
	void deleteReportById(Long reportId);

}

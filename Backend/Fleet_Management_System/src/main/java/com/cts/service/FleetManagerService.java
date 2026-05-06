package com.cts.service;

import com.cts.dto.request.CreateFleetManagerRequest;
import com.cts.dto.request.UpdateFleetManagerRequest;
import com.cts.dto.response.FleetManagerResponse;
import com.cts.entity.FleetManager;

import java.util.List;

public interface FleetManagerService {

    FleetManagerResponse createFleetManager(CreateFleetManagerRequest request);

    FleetManager deleteFleetManager(Long id);

    FleetManagerResponse updateFleetManager(Long id, UpdateFleetManagerRequest request);

    List<FleetManagerResponse> getAllFleetManagers();

    FleetManagerResponse getFleetManagerById(Long id);
}
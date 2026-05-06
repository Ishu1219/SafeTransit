package com.cts.service;
 
import com.cts.dto.request.CreateDriverRequest;

import com.cts.dto.request.UpdateDriverRequest;

import com.cts.dto.response.DriverResponse;

import com.cts.entity.Driver;
 
import java.util.List;
 
public interface DriverService {
 
    DriverResponse createDriver(CreateDriverRequest request);
 
    Driver deleteDriver(Long id);
 
    DriverResponse updateDriver(Long id, UpdateDriverRequest request);
 

    List<DriverResponse> getAllDrivers();
 
    DriverResponse getDriverById(Long id);

}

 
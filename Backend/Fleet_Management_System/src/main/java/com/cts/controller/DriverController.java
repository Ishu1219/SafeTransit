package com.cts.controller;
 
import com.cts.dto.request.CreateDriverRequest; 
import com.cts.dto.request.UpdateDriverRequest;
import com.cts.dto.response.DriverResponse;
import com.cts.entity.Driver;
import com.cts.api.APIResponse;
import com.cts.service.DriverService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
 
import java.util.List;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
 
    private final DriverService driverService;
 
   
    @PostMapping("/create")
    public ResponseEntity<APIResponse<DriverResponse>> createDriver(
           @Valid @RequestBody CreateDriverRequest request) {
        DriverResponse response = driverService.createDriver(request);
 
        APIResponse<DriverResponse> apiResponse = new APIResponse<>(
                "success",
                "Driver created successfully",
                response
        );
 
        return ResponseEntity.ok(apiResponse);
    }
 
   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Driver>> deleteDriver(@PathVariable Long id) {
        Driver response = driverService.deleteDriver(id);
 
        APIResponse<Driver> apiResponse = new APIResponse<>(
                "success",
                "Driver deleted successfully",
                response
        );
 
        return ResponseEntity.ok(apiResponse);
    }
 
   
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<DriverResponse>> updateDriver(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDriverRequest request) {
 
        DriverResponse response = driverService.updateDriver(id, request);
 
        APIResponse<DriverResponse> apiResponse = new APIResponse<>(
                "success",
                "Driver updated successfully",
                response
        );
 
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<List<DriverResponse>>> getAllDrivers() {
        List<DriverResponse> response = driverService.getAllDrivers();
 
        APIResponse<List<DriverResponse>> apiResponse = new APIResponse<>(
                "success",
                "Drivers fetched successfully",
                response
        );
 
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<DriverResponse>> getDriverById(@PathVariable Long id) {
        DriverResponse response = driverService.getDriverById(id);
 
        APIResponse<DriverResponse> apiResponse = new APIResponse<>(
                "success",
                "Driver fetched successfully",
                response
        );
 
        return ResponseEntity.ok(apiResponse);
    }
 
 
}
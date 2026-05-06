package com.cts.controller;

import com.cts.dto.request.CreateFleetManagerRequest;  
import com.cts.dto.request.UpdateFleetManagerRequest;
import com.cts.dto.response.FleetManagerResponse;
import com.cts.entity.FleetManager;
import com.cts.api.APIResponse;
import com.cts.service.FleetManagerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fleetManagers")
@RequiredArgsConstructor
public class FleetManagerController {

    private final FleetManagerService fleetManagerService;

  
    @PostMapping("/create")
    public ResponseEntity<APIResponse<FleetManagerResponse>> createFleetManager(
           @Valid @RequestBody CreateFleetManagerRequest request) {

        FleetManagerResponse response = fleetManagerService.createFleetManager(request);

        APIResponse<FleetManagerResponse> apiResponse = new APIResponse<>(
                "success",
                "Fleet Manager created successfully",
                response
        );

        return ResponseEntity.ok(apiResponse);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<FleetManager>> deleteFleetManager(
            @PathVariable Long id) {

        FleetManager response = fleetManagerService.deleteFleetManager(id);

        APIResponse<FleetManager> apiResponse = new APIResponse<>(
                "success",
                "Fleet Manager deleted successfully",
                response
        );

        return ResponseEntity.ok(apiResponse);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<FleetManagerResponse>> updateFleetManager(
            @PathVariable Long id,
          @Valid  @RequestBody UpdateFleetManagerRequest request) {

        FleetManagerResponse response = fleetManagerService.updateFleetManager(id, request);

        APIResponse<FleetManagerResponse> apiResponse = new APIResponse<>(
                "success",
                "Fleet Manager updated successfully",
                response
        );

        return ResponseEntity.ok(apiResponse);
    }

   
    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<List<FleetManagerResponse>>> getAllFleetManagers() {

        List<FleetManagerResponse> response = fleetManagerService.getAllFleetManagers();

        APIResponse<List<FleetManagerResponse>> apiResponse = new APIResponse<>(
                "success",
                "Fleet Managers fetched successfully",
                response
        );

        return ResponseEntity.ok(apiResponse);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<FleetManagerResponse>> getFleetManagerById(
            @PathVariable Long id) {

        FleetManagerResponse response = fleetManagerService.getFleetManagerById(id);

        APIResponse<FleetManagerResponse> apiResponse = new APIResponse<>(
                "success",
                "Fleet Manager fetched successfully",
                response
        );

        return ResponseEntity.ok(apiResponse);
    }
}
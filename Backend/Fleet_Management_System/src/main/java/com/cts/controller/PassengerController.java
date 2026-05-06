package com.cts.controller;

import com.cts.dto.request.CreatePassengerRequest; 
import com.cts.dto.request.UpdatePassengerRequest;
import com.cts.dto.response.PassengerResponse;

import com.cts.api.APIResponse;
import com.cts.service.PassengerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<PassengerResponse>> createPassenger(
            @Valid @RequestBody CreatePassengerRequest request) {

        PassengerResponse response =
                passengerService.createPassenger(request);

        return ResponseEntity.ok(
                new APIResponse<>(
                        "success",
                        "Passenger created successfully",
                        response
                )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<PassengerResponse>> updatePassenger(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePassengerRequest request) {

        PassengerResponse response =
                passengerService.updatePassenger(id, request);

        return ResponseEntity.ok(
                new APIResponse<>(
                        "success",
                        "Passenger updated successfully",
                        response
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<PassengerResponse>> deletePassenger(
            @PathVariable Long id) {

        PassengerResponse response =
                passengerService.deletePassenger(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        "success",
                        "Passenger deleted successfully",
                        response
                )
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<APIResponse<PassengerResponse>> getPassenger(
            @PathVariable Long id) {

        PassengerResponse response =
                passengerService.getPassenger(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        "success",
                        "Passenger fetched successfully",
                        response
                )
        );
    }
    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<java.util.List<PassengerResponse>>> getAllPassengers() {
        java.util.List<PassengerResponse> response =
                passengerService.getAllPassengers();
        return ResponseEntity.ok(
                new APIResponse<>(
                        "success",
                        "Passengers fetched successfully",
                        response
                )
        );
    }
}
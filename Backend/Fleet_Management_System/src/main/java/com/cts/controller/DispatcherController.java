package com.cts.controller;

import com.cts.api.APIResponse; 
import com.cts.dto.request.CreateDispatcherRequest;
import com.cts.dto.request.UpdateDispatcherRequest;
import com.cts.dto.response.DispatcherResponse;
import com.cts.service.DispatcherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispatchers")
@RequiredArgsConstructor
public class DispatcherController {

    private final DispatcherService dispatcherService;


    @PostMapping("/create")
    public ResponseEntity<APIResponse<DispatcherResponse>> createDispatcher(
            @Valid @RequestBody CreateDispatcherRequest request) {

        DispatcherResponse response =
                dispatcherService.createDispatcher(request);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Dispatcher created successfully", response)
        );
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<DispatcherResponse>> updateDispatcher(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDispatcherRequest request) {

        DispatcherResponse response =
                dispatcherService.updateDispatcher(id, request);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Dispatcher updated successfully", response)
        );
    }


    @GetMapping("/dispatcher/getById/{id}")
    public ResponseEntity<APIResponse<DispatcherResponse>> getDispatcherById(@PathVariable Long id) {

        DispatcherResponse response = dispatcherService.getDispatcherById(id);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Dispatcher found", response)
        );
    }

    @GetMapping("/GETALL")
    public ResponseEntity<APIResponse<List<DispatcherResponse>>> getAllDispatchers() {

        List<DispatcherResponse> response = dispatcherService.getAllDispatchers();

        return ResponseEntity.ok(
                new APIResponse<>("success", "All dispatchers fetched", response)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<String>> deleteDispatcher(@PathVariable Long id) {

        dispatcherService.deleteDispatcher(id);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Dispatcher deleted successfully", null)
        );
    }
}
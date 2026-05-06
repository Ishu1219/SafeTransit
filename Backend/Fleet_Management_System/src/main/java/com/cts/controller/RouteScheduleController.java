package com.cts.controller;

import com.cts.api.APIResponse; 
import com.cts.dto.request.CreateRouteScheduleRequest;
import com.cts.dto.request.UpdateRouteScheduleRequest;
import com.cts.dto.response.RouteScheduleResponse;
import com.cts.service.RouteScheduleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route-schedules")
@RequiredArgsConstructor
public class RouteScheduleController {

    private final RouteScheduleService routeScheduleService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<RouteScheduleResponse>> create(
          @Valid  @RequestBody CreateRouteScheduleRequest request) {

        return ResponseEntity.ok(
                new APIResponse<>("success", "Route scheduled successfully",
                        routeScheduleService.createRouteSchedule(request))
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<RouteScheduleResponse>> update(
            @PathVariable Long id,
            @RequestBody UpdateRouteScheduleRequest request) {

        return ResponseEntity.ok(
                new APIResponse<>("success", "Route schedule updated successfully",
                        routeScheduleService.updateRouteSchedule(id, request))
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<String>> delete(@PathVariable Long id) {

        routeScheduleService.deleteRouteSchedule(id);

        return ResponseEntity.ok(
                new APIResponse<>("success", "Route schedule deleted", "Deleted")
        );
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<APIResponse<RouteScheduleResponse>> getById(@PathVariable Long id) {

        return ResponseEntity.ok(
                new APIResponse<>("success", "Route schedule fetched",
                        routeScheduleService.getRouteScheduleById(id))
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<List<RouteScheduleResponse>>> getAll() {

        return ResponseEntity.ok(
                new APIResponse<>("success", "All route schedules fetched",
                        routeScheduleService.getAllRouteSchedules())
        );
    }
}
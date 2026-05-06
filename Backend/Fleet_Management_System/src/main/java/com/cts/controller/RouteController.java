package com.cts.controller;

import java.util.List;  

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cts.api.APIResponse;
import com.cts.dto.request.CreateRouteRequest;
import com.cts.dto.request.UpdateRouteRequest;
import com.cts.dto.response.RouteResponseDTO;
import com.cts.entity.Route;
import com.cts.service.RouteScheduleService;
import com.cts.service.RouteService;
import com.cts.service.imp.RouteServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
  
@RestController

@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {
	
	private final RouteService routeService;
	
	@PostMapping("/create")
	public ResponseEntity<APIResponse<RouteResponseDTO>> addRoute(@Valid @RequestBody CreateRouteRequest route)
	{
		RouteResponseDTO response = routeService.addRoute(route);
		APIResponse<RouteResponseDTO> apiResponse = new APIResponse<>(
                "success",
                "Route created successfully",
                response
        );
        return ResponseEntity.ok(apiResponse);
    }
	
	@GetMapping("/getAllRoutes")
	public List<Route> getAllRoutes()
	{
		return routeService.getAllRoutes();
	}
	@GetMapping("/getById/{id}")
	public Route getById(@PathVariable int id)
	{
		return routeService.getRouteById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<APIResponse<RouteResponseDTO>> updateRoute(
	        @PathVariable int id,
	        @Valid @RequestBody UpdateRouteRequest routeRequestDTO) {

	    RouteResponseDTO updatedRoute = routeService.updateRoute(id, routeRequestDTO);
	    APIResponse<RouteResponseDTO> apiResponse = new APIResponse<>(
	            "success",
	            "Route updated successfully",
	            updatedRoute
	    );
	    return ResponseEntity.ok(apiResponse);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse<Void>> deleteRoute(@PathVariable int id) {
	    routeService.deleteRoute(id);
	    APIResponse<Void> apiResponse = new APIResponse<>(
	            "success",
	            "Route deleted successfully",
	            null
	    );
	    return ResponseEntity.ok(apiResponse);
	}
	
}

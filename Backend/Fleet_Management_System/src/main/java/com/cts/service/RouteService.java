package com.cts.service;

import java.util.List;


import com.cts.dto.request.CreateRouteRequest;
import com.cts.dto.request.UpdateRouteRequest;
import com.cts.dto.response.RouteResponseDTO;
import com.cts.entity.Route;

public interface RouteService {

	RouteResponseDTO addRoute(CreateRouteRequest routeRequestDto);
	List<Route> getAllRoutes();
	Route getRouteById(int routeId);
	
	RouteResponseDTO updateRoute(int routeId, UpdateRouteRequest routeRequestDto);
	void deleteRoute(int routeId);
}

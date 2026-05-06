package com.cts.mapper;

import org.springframework.stereotype.Component;

import com.cts.dto.request.CreateRouteRequest;
import com.cts.dto.response.RouteResponseDTO;
import com.cts.entity.Route;
import com.cts.enums.RouteStatus;

@Component
public class RouteMapper {

	public Route toEntity(CreateRouteRequest dto)
	{
		return Route.builder()
				    .routeName(dto.getRouteName())
				    .routeStops(dto.getRouteStops())
				    .distanceKm(dto.getDistanceKm())
				    .routeStatus(RouteStatus.ACTIVE)
				    .build();
	}
	
	public RouteResponseDTO toOutputDTO(Route entity)
	{
		return RouteResponseDTO.builder()
				              .routeId(entity.getRouteId())
				              .routeName(entity.getRouteName())
							  .routeStops(entity.getRouteStops())
							  .distanceKm(entity.getDistanceKm())
							  .routeStatus(entity.getRouteStatus())
							  .build();
	}
}

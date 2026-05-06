package com.cts.service.imp;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.request.CreateRouteRequest;
import com.cts.dto.request.UpdateRouteRequest;
import com.cts.dto.response.RouteResponseDTO;
import com.cts.entity.Route;
import com.cts.exception.AlreadyExistException;
import com.cts.exception.NotExistException;
import com.cts.mapper.RouteMapper;
import com.cts.repository.RouteRepository;
import com.cts.service.RouteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

	@Override
	public RouteResponseDTO addRoute(CreateRouteRequest routeRequestDto) {
		Route route=routeMapper.toEntity(routeRequestDto);
		Route alreadyExistingRoute=routeRepository.findByrouteName(route.getRouteName());
		 if(alreadyExistingRoute!=null){
	        	throw new AlreadyExistException("Route already exists with this Name");
	        }
		Route savedroute = routeRepository.save(route);
		return routeMapper.toOutputDTO(savedroute);
	}

	@Override
	public List<Route> getAllRoutes() {
		List<Route> routes = routeRepository.findAll();
		return routes;
	}

	@Override
	public Route getRouteById(int routeId) {
		Route route=routeRepository.findById(routeId).orElseThrow(()->new NotExistException("Route not found with id: " + routeId));
		return route;
	}

	
	@Override
	public RouteResponseDTO updateRoute(int routeId, UpdateRouteRequest routeRequestDto) {
	    Route existingRoute = routeRepository.findById(routeId)
	            .orElseThrow(() -> new NotExistException("Route not found with id " + routeId));

	    if (routeRequestDto.getRouteName() != null) {
	        existingRoute.setRouteName(routeRequestDto.getRouteName());
	    }

	    if (routeRequestDto.getRouteStops() != null && !routeRequestDto.getRouteStops().isEmpty()) {
	        existingRoute.setRouteStops(routeRequestDto.getRouteStops());
	    }

	    if (routeRequestDto.getDistanceKm() != 0) {
	        existingRoute.setDistanceKm(routeRequestDto.getDistanceKm());
	    }

	    if (routeRequestDto.getStatus() != null) {
	        existingRoute.setRouteStatus(routeRequestDto.getStatus());
	    }


	    Route updatedRoute = routeRepository.save(existingRoute);
	    return routeMapper.toOutputDTO(updatedRoute);
	}

	@Override
	public void deleteRoute(int routeId) {
	    if (!routeRepository.existsById(routeId)) {
	        throw new NotExistException("Route not found with id " + routeId);
	    }
	    routeRepository.deleteById(routeId);
	}
	
	

}

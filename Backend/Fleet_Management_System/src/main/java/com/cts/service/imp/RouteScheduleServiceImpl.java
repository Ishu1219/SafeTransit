package com.cts.service.imp;

import com.cts.dto.request.CreateRouteScheduleRequest;
import com.cts.dto.request.UpdateRouteScheduleRequest;
import com.cts.dto.response.RouteScheduleResponse;
import com.cts.entity.*;
import com.cts.enums.RouteScheduleStatus;
import com.cts.enums.RouteStatus;
import com.cts.exception.AlreadyExistException;
import com.cts.exception.NotExistException;
import com.cts.mapper.RouteScheduleMapper;
import com.cts.repository.*;
import com.cts.service.RouteScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RouteScheduleServiceImpl implements RouteScheduleService {

    private final RouteScheduleRepository routeScheduleRepository;
    private final RouteRepository routeRepository;
    private final VehicleRepository vehicleRepository;
    private final DispatcherRepository dispatcherRepository;

    @Override
    public RouteScheduleResponse createRouteSchedule(CreateRouteScheduleRequest request) {

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() -> new NotExistException("Route not found"));
        
        if (route.getRouteStatus() != RouteStatus.ACTIVE) {
            throw new AlreadyExistException("Cannot create schedule for inactive route");
        }

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new NotExistException("Vehicle not found"));

        Dispatcher dispatcher = dispatcherRepository.findById(request.getDispatcherId())
                .orElseThrow(() -> new NotExistException("Dispatcher not found"));

        RouteSchedule schedule =
                RouteScheduleMapper.toEntity(request, route, vehicle, dispatcher);

        return RouteScheduleMapper.toResponse(
                routeScheduleRepository.save(schedule)
        );
    }

    @Override
    public RouteScheduleResponse updateRouteSchedule(Long id, UpdateRouteScheduleRequest request) {

        RouteSchedule schedule = routeScheduleRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Route Schedule not found"));

        if (request.getScheduleDate() != null)
            schedule.setScheduleDate(LocalDate.parse(request.getScheduleDate()));

        if (request.getStartTime() != null)
            schedule.setStartTime(request.getStartTime());

        if (request.getEndTime() != null)
            schedule.setEndTime(request.getEndTime());

        if (request.getStatus() != null)
            schedule.setStatus(RouteScheduleStatus.valueOf(request.getStatus().toUpperCase()));

        return RouteScheduleMapper.toResponse(
                routeScheduleRepository.save(schedule)
        );
    }

    @Override
    public void deleteRouteSchedule(Long id) {
        routeScheduleRepository.deleteById(id);
    }

    @Override
    public RouteScheduleResponse getRouteScheduleById(Long id) {
        return routeScheduleRepository.findById(id)
                .map(RouteScheduleMapper::toResponse)
                .orElseThrow(() -> new NotExistException("Route Schedule not found"));
    }

    @Override
    public List<RouteScheduleResponse> getAllRouteSchedules() {
        return routeScheduleRepository.findAll()
                .stream()
                .map(RouteScheduleMapper::toResponse)
                .collect(Collectors.toList());
    }
}
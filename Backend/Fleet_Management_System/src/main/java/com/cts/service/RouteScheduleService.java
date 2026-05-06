package com.cts.service;

import com.cts.dto.request.CreateRouteScheduleRequest;
import com.cts.dto.request.UpdateRouteScheduleRequest;
import com.cts.dto.response.RouteScheduleResponse;

import java.util.List;

public interface RouteScheduleService {

    RouteScheduleResponse createRouteSchedule(CreateRouteScheduleRequest request);

    RouteScheduleResponse updateRouteSchedule(Long scheduleId, UpdateRouteScheduleRequest request);

    void deleteRouteSchedule(Long scheduleId);

    RouteScheduleResponse getRouteScheduleById(Long scheduleId);

    List<RouteScheduleResponse> getAllRouteSchedules();
}
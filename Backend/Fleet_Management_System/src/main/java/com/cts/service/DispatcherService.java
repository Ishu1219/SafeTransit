package com.cts.service;

import com.cts.dto.request.CreateDispatcherRequest;
import com.cts.dto.request.UpdateDispatcherRequest;
import com.cts.dto.response.DispatcherResponse;

import java.util.List;

public interface DispatcherService {

    DispatcherResponse createDispatcher(CreateDispatcherRequest request);

    DispatcherResponse updateDispatcher(Long id, UpdateDispatcherRequest request);

    DispatcherResponse getDispatcherById(Long id);

    List<DispatcherResponse> getAllDispatchers();

    void deleteDispatcher(Long id);
}
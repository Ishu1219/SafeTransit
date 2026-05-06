package com.cts.service;

import com.cts.dto.request.CreateOperationsManagerRequest;
import com.cts.dto.request.UpdateOperationsManagerRequest;
import com.cts.dto.response.OperationsManagerResponse;
import com.cts.entity.OperationsManager;

import java.util.List;

public interface OperationsManagerService {

    OperationsManagerResponse createOperationsManager(
            CreateOperationsManagerRequest request);

    OperationsManager deleteOperationsManager(Long id);

    OperationsManagerResponse updateOperationsManager(
            Long id, UpdateOperationsManagerRequest request);

    OperationsManagerResponse getOperationsManagerById(Long id);

    List<OperationsManagerResponse> getAllOperationsManagers();
}

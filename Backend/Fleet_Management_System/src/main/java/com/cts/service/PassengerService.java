
package com.cts.service;

import java.util.List;

import com.cts.dto.request.CreatePassengerRequest;
import com.cts.dto.request.UpdatePassengerRequest;
import com.cts.dto.response.PassengerResponse;
import com.cts.entity.Passenger;

public interface PassengerService {

    PassengerResponse createPassenger(CreatePassengerRequest request);
    PassengerResponse deletePassenger(Long id);
    PassengerResponse updatePassenger(Long id, UpdatePassengerRequest request);
    PassengerResponse getPassenger(Long id);
    List<PassengerResponse> getAllPassengers();
}

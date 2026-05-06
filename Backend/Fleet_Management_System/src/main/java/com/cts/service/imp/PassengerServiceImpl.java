package com.cts.service.imp;

import com.cts.dto.request.CreatePassengerRequest;
import com.cts.dto.request.UpdatePassengerRequest;
import com.cts.dto.response.PassengerResponse;
import com.cts.entity.Passenger;
import com.cts.entity.User;
import com.cts.enums.AuditAction;
import com.cts.enums.Role;
import com.cts.enums.Sex;
//import com.cts.enums.UserStatus;
import com.cts.exception.AlreadyExistException;
import com.cts.mapper.PassengerMapper;
import com.cts.mapper.UserMapper;
import com.cts.repository.PassengerRepository;
import com.cts.repository.UserRepository;
import com.cts.service.PassengerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.cts.exception.NotExistException;
//import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder     passwordEncoder;  

    @Override
    @Transactional
    public PassengerResponse createPassenger(CreatePassengerRequest request) {

        
        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new AlreadyExistException("User already exists with this email");
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
       
        User user = UserMapper.createUser(
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                encodedPassword,
                Role.PASSENGER
        );

        User savedUser = userRepository.save(user);

        Passenger passenger = PassengerMapper.toEntity(request, user);
        passenger.setPassword(encodedPassword);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return PassengerMapper.toResponse(savedPassenger);
    }

    @Override
    public PassengerResponse deletePassenger(Long id) {


    	Passenger passenger = passengerRepository.findById(id)
            .orElseThrow(() -> new NotExistException("Passenger not found"));


	    passengerRepository.delete(passenger);


        return PassengerMapper.toResponse(passenger);
    }
    @Override
    @Transactional
    public PassengerResponse updatePassenger(Long id, UpdatePassengerRequest request) {

    	Passenger passenger = passengerRepository.findById(id)
    	        .orElseThrow(() -> new NotExistException("Passenger not found"));

    	User user = passenger.getUser();

    	
    	if (request.getName() != null) passenger.setName(request.getName());
    	if (request.getPhone() != null) passenger.setPhone(request.getPhone());
    	if (request.getSex() != null) {
    	    passenger.setSex(Sex.valueOf(request.getSex().toUpperCase()));
    	}
    	if (request.getStatus() != null) {
    		passenger.setStatus(AuditAction.fromString(request.getStatus()));
    	}
    	if(request.getEmail() != null) {
    		passenger.setEmail(request.getEmail());
    	}
    	if(request.getPassword()!=null) {
    		passenger.setPassword(request.getPassword());
    	}
    	
    	if (request.getName() != null) user.setName(request.getName());
    	if (request.getPhone() != null) user.setPhone(request.getPhone());
    	if(request.getEmail() != null) {
    		user.setEmail(request.getEmail());
    	}
    	if(request.getPassword()!=null) {
    		user.setPassword(request.getPassword());
    	}
  	userRepository.save(user);
    	passengerRepository.save(passenger);

        return PassengerMapper.toResponse(passenger);
    }
    @Override
    public PassengerResponse getPassenger(Long id) {
    	Passenger passenger=passengerRepository.findById(id)
    			.orElseThrow(()->new NotExistException("Passenger not found with id: " + id));
    	
    	return PassengerMapper.toResponse(passenger);
    }
    @Override
    public List<PassengerResponse> getAllPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(PassengerMapper::toResponse)
                .collect(Collectors.toList());
    }
}
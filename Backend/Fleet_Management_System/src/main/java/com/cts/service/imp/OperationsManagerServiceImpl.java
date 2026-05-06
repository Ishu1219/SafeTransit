package com.cts.service.imp;

import com.cts.dto.request.CreateOperationsManagerRequest;
import com.cts.dto.request.UpdateOperationsManagerRequest;
import com.cts.dto.response.OperationsManagerResponse;
import com.cts.entity.OperationsManager;
import com.cts.entity.User;
import com.cts.enums.Role;
import com.cts.exception.AlreadyExistException;
import com.cts.exception.NotExistException;
import com.cts.mapper.OperationsManagerMapper;
import com.cts.mapper.UserMapper;
import com.cts.repository.OperationsManagerRepository;
import com.cts.repository.UserRepository;
import com.cts.service.OperationsManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationsManagerServiceImpl implements OperationsManagerService {

    private final OperationsManagerRepository repository;
    private final UserRepository              userRepository;
    private final PasswordEncoder             passwordEncoder;

    @Override
    public OperationsManagerResponse createOperationsManager(
            CreateOperationsManagerRequest request) {

        OperationsManager existing = repository.findByEmail(request.getEmail());
        if (existing != null) {
            throw new AlreadyExistException(
                    "Operations Manager already exists with email: " + request.getEmail());
        }

        
        String encodedPassword = passwordEncoder.encode(request.getPassword());

       
        User user = UserMapper.createUser(
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                encodedPassword,
                Role.OPERATIONS_MANAGER
        );
        userRepository.save(user);

      
        OperationsManager om = OperationsManagerMapper.toEntity(request, user);
        om.setPassword(encodedPassword); 

        OperationsManager saved = repository.save(om);
        return OperationsManagerMapper.toResponse(saved);
    }

    @Override
    public OperationsManager deleteOperationsManager(Long id) {
        OperationsManager existing = repository.findByOperationsManagerId(id);
        if (existing == null) {
            throw new NotExistException("Operations Manager not found with id: " + id);
        }
        repository.deleteById(id);
        return existing;
    }

    @Override
    public OperationsManagerResponse updateOperationsManager(
            Long id, UpdateOperationsManagerRequest request) {

        OperationsManager om = repository.findById(id)
                .orElseThrow(() ->
                        new NotExistException("Operations Manager not found with id: " + id));

        if (request.getName() != null) {
            om.setName(request.getName());
        }

        if (request.getEmail() != null) {
            om.setEmail(request.getEmail());
        }

        if (request.getPhone() != null) {
            om.setPhone(request.getPhone());
        }

        if (request.getEmergencyContact() != null) {
            om.setEmergencyContact(request.getEmergencyContact());
        }

        if (request.getAddress() != null) {
            om.setAddress(request.getAddress());
        }

        if (request.getBloodGroup() != null) {
            om.setBloodGroup(request.getBloodGroup());
        }

        if (request.getStatus() != null) {
            om.setStatus(request.getStatus());
        }

        OperationsManager updated = repository.save(om);

        return OperationsManagerMapper.toResponse(updated);
    }

    @Override
    public OperationsManagerResponse getOperationsManagerById(Long id) {
        return OperationsManagerMapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() ->
                                new NotExistException(
                                        "Operations Manager not found with id: " + id)));
    }

    @Override
    public List<OperationsManagerResponse> getAllOperationsManagers() {
        return repository.findAll()
                .stream()
                .map(OperationsManagerMapper::toResponse)
                .collect(Collectors.toList());
    }
}
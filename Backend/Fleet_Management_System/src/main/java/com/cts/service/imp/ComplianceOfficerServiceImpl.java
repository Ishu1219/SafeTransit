package com.cts.service.imp;
  
import com.cts.dto.request.CreateComplianceOfficerRequest; 
import com.cts.dto.request.UpdateComplianceOfficerRequest;
import com.cts.dto.response.ComplianceOfficerResponse;
import com.cts.entity.ComplianceOfficer;
import com.cts.entity.User;
import com.cts.enums.ComplainceOfficer;
import com.cts.enums.Role;
import com.cts.enums.UserStatus;
import com.cts.exception.AlreadyExistException;
import com.cts.exception.NotExistException;
import com.cts.mapper.ComplianceOfficerMapper;
import com.cts.mapper.UserMapper;
import com.cts.repository.ComplianceOfficerRepository;
import com.cts.repository.UserRepository;
import com.cts.service.ComplianceOfficerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
 
@Service
@RequiredArgsConstructor
public class ComplianceOfficerServiceImpl implements ComplianceOfficerService {
 
    private final ComplianceOfficerRepository complianceOfficerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
 
   
    @Override
    public ComplianceOfficerResponse createOfficer(CreateComplianceOfficerRequest request) {
        ComplianceOfficer existingOfficer = complianceOfficerRepository.findByEmail(request.getEmail());
        if (existingOfficer != null) {
            throw new AlreadyExistException("Compliance Officer already exists with email: " + request.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = UserMapper.createUser(
                request.getName(),
                request.getEmail(),
                request.getPhone(),
               encodedPassword,
                Role.COMPLIANCE_OFFICER
        );
        User savedUser = userRepository.save(user);
        ComplianceOfficer officer = ComplianceOfficerMapper.toEntity(request,user);
        officer.setPassword(encodedPassword);
        ComplianceOfficer savedOfficer = complianceOfficerRepository.save(officer);
        return ComplianceOfficerMapper.toResponse(savedOfficer);
    }
 
    @Override
    public ComplianceOfficer deleteOfficer(Long id) {
        ComplianceOfficer existingOfficer = complianceOfficerRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Compliance Officer not found with id: " + id));
 
        complianceOfficerRepository.deleteById(id);
        return existingOfficer;
    }
@Override
    public ComplianceOfficerResponse updateOfficer(Long id, UpdateComplianceOfficerRequest request) {
    	   ComplianceOfficer officer = complianceOfficerRepository.findById(id)
                   .orElseThrow(() -> new NotExistException("Compliance Officer not found with id: " + id));
 
       
        User user = officer.getUser();
 
        if (request.getName() != null) {
            officer.setName(request.getName());
            user.setName(request.getName());      
        }
 
        if (request.getEmail() != null) {
            officer.setEmail(request.getEmail());
            user.setEmail(request.getEmail());    
        }
 
        if (request.getPhone() != null) {
            officer.setPhone(request.getPhone());
            user.setPhone(request.getPhone());    
        }
        if (request.getSex() != null) {
            officer.setSex(request.getSex());
        }
 
        if (request.getPassword() != null) {
            officer.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setPassword(passwordEncoder.encode(request.getPassword())); 
        }
 
        if (request.getStatus() != null) {
            officer.setStatus(ComplainceOfficer.valueOf(request.getStatus()));
            user.setStatus(UserStatus.USER_UPDATED); 
        }
 
        userRepository.save(user);                          
        ComplianceOfficer updated = complianceOfficerRepository.save(officer); 
        return ComplianceOfficerMapper.toResponse(updated);
    }
 
   
    @Override
    public List<ComplianceOfficerResponse> getAllOfficers() {
        return complianceOfficerRepository.findAll()
                .stream()
                .map(ComplianceOfficerMapper::toResponse)
                .collect(Collectors.toList());
    }
 
   
    @Override
    public ComplianceOfficerResponse getOfficerById(Long id) {
        ComplianceOfficer officer = complianceOfficerRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Compliance Officer not found with id: " + id));
 
        return ComplianceOfficerMapper.toResponse(officer);
    }
}

 
 

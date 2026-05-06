package com.cts.controller;

import com.cts.api.APIResponse; 
import com.cts.dto.request.LoginRequest;
import com.cts.dto.response.LoginResponse;
import com.cts.entity.User;
import com.cts.repository.UserRepository;
import com.cts.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	 private final AuthenticationManager authManager;
	    private final UserRepository        userRepository;
	    private final JwtUtil               jwtUtil;

	    @PostMapping("/login")
	    public ResponseEntity<APIResponse<LoginResponse>> login(
	            @Valid @RequestBody LoginRequest request) {

	        try {
	            
	            authManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            request.getEmail(),
	                            request.getPassword()
	                    )
	            );
	        } catch (AuthenticationException ex) {
	            return ResponseEntity
	                    .status(HttpStatus.UNAUTHORIZED)
	                    .body(APIResponse.<LoginResponse>builder()
	                            .status("FAILURE")
	                            .message(ex.getMessage())  
	                            .build());
	        }

	        
	        User user = userRepository.findByEmail(request.getEmail());

	       
	        String token = jwtUtil.generateToken(
	                user.getUserID(),
	                user.getEmail(),
	                user.getRole().name()
	        );

	      
	        LoginResponse resp = LoginResponse.builder()
	                .token(token)
	                .role(user.getRole().name())
	                .email(user.getEmail())
	                .name(user.getName())
	                .userId(user.getUserID())
	                .expiresInSeconds(jwtUtil.getExpirySeconds())
	                .build();

	        return ResponseEntity.ok(
	                APIResponse.<LoginResponse>builder()
	                        .status("SUCCESS")
	                        .message("Login successful")
	                        .data(resp)
	                        .build()
	        );
	    }

}

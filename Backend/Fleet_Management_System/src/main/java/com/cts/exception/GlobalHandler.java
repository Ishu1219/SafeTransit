package com.cts.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.api.APIResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<APIResponse<Void>> alreadyExistException(
            AlreadyExistException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message(ex.getMessage())
                        .build());
    }

   
    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<APIResponse<Void>> notExistException(
            NotExistException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message(ex.getMessage())
                        .build());
    }

    
    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<APIResponse<Void>> unAuthorizedException(
            UnAuthorizedException ex) {

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message(ex.getMessage())
                        .build());
    }

  
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Map<String, String>>> validationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(APIResponse.<Map<String, String>>builder()
                        .status("FAILURE")
                        .message("Validation failed")
                        .data(errors)
                        .build());
    }

   
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse<Void>> jsonException(
            HttpMessageNotReadableException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message("Invalid request format or enum value")
                        .build());
    }

    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse<Void>> constraintViolationException(
            ConstraintViolationException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message(ex.getMessage())
                        .build());
    }
    @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
    public ResponseEntity<APIResponse<Void>> accessDenied(
            org.springframework.security.access.AccessDeniedException ex) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message("Access denied: you do not have permission")
                        .build());
    }

    @ExceptionHandler(org.springframework.security.core.AuthenticationException.class)
    public ResponseEntity<APIResponse<Void>> authException(
            org.springframework.security.core.AuthenticationException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(APIResponse.<Void>builder()
                        .status("FAILURE")
                        .message("Unauthorized: " + ex.getMessage())
                        .build());
    }

}

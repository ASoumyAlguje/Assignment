package com.build.exceptions;

import com.build.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GolbalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex)
    {
        String msg = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(msg, false);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String, String>> argumentNotValidHandler(MethodArgumentNotValidException ex)
    {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldNme = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldNme, message);
        });

        return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);

    }

 }

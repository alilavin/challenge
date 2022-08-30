package com.arisa.spring_data_part.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException exception){

        Map<String,Object> response=new HashMap<>();
        response.put("message",exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<?> conflictException(ConflictException exception){
        Map<String,Object> response=new HashMap<>();
        response.put("message",exception.getMessage());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

}

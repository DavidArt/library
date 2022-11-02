package com.motomania.library.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorCode> handleConflict(EntityNotFoundException e) {
        ErrorCode errorCode = new ErrorCode("404", e.getMessage());

        return new ResponseEntity<>(errorCode, HttpStatus.NOT_FOUND);
    }
}


package com.tasksmartpro.userprofile.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFound(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> business(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

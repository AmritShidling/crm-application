package com.lead.service.crm_lead_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LeadNotFoundException.class)
    public ResponseEntity<APIError> handleLeadNotFoundException(LeadNotFoundException ex, HttpServletRequest request){
        APIError error = new APIError(
                HttpStatus.NOT_FOUND.value(),
                "Lead not found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

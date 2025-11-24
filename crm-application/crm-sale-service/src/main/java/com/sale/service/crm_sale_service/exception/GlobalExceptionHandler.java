package com.sale.service.crm_sale_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DealNotFoundException.class)
    public ResponseEntity<APIError> handleDealNotFoundException(DealNotFoundException ex, HttpServletRequest request){
        APIError error = new APIError(HttpStatus.NOT_FOUND.value(),
                "Deal Not Found",
                ex.getMessage(),
                request.getRequestURI()
                );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

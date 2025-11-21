package com.customer.service.crm_customer_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<APIError> handleNotFound(CustomerNotFoundException ex, HttpServletRequest req){
        APIError error = new APIError(
                HttpStatus.NOT_FOUND.value(),
                "Customer not found",
                ex.getMessage(),
                req.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateCustomerException.class)
    public ResponseEntity<APIError> handleDuplicate(DuplicateCustomerException ex, HttpServletRequest req){
        APIError error = new APIError(
                HttpStatus.CONFLICT.value(),
                "Duplicate Customer Found",
                ex.getMessage(),
                req.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCustomerDataException.class)
    public ResponseEntity<APIError> handleInvalidData(InvalidCustomerDataException ex, HttpServletRequest req){
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Data",
                ex.getMessage(),
                req.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // ❗ You missed this annotation
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleGeneral(Exception ex, HttpServletRequest req){
        APIError error = new APIError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong",
                ex.getMessage(),
                req.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

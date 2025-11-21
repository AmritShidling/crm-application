package com.customer.service.crm_customer_service.exception;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class APIError {
    private LocalDateTime timeSlot;
    private int status;
    private String error;
    private String message;
    private String path;
    public APIError(int status, String error, String message, String path){
        this.timeSlot = LocalDateTime.now();
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
    }
 }

package com.sale.service.crm_sale_service.exception;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class APIError {
    private LocalDateTime localDateTime;
    private int status;
    private String error;
    private String message;
    private String path;

    public APIError(int status, String error, String message, String path){
        this.localDateTime = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}

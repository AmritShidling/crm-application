package com.customer.service.crm_customer_service.exception;

public class DuplicateCustomerException extends RuntimeException{
    public DuplicateCustomerException(String message){
        super(message);
    }
}

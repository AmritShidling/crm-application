package com.customer.service.crm_customer_service.exception;

public class InvalidCustomerDataException extends RuntimeException{
    public InvalidCustomerDataException(String message){
        super(message);
    }
}

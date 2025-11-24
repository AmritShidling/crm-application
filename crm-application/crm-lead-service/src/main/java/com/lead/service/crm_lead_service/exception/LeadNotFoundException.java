package com.lead.service.crm_lead_service.exception;

public class LeadNotFoundException extends RuntimeException{
    public LeadNotFoundException(String message){
        super(message);
    }
}

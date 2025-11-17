package com.lead.service.crm_lead_service.service;

import com.lead.service.crm_lead_service.model.Lead;
import com.lead.service.crm_lead_service.model.LeadStatus;
import com.lead.service.crm_lead_service.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class LeadService {
    private final LeadRepository repository;
    public LeadService(LeadRepository repository){
        this.repository = repository;
    }

    public Lead createLead(Lead lead){
        return repository.save(lead);
    }

    public List<Lead> getAllLeads(){
        return this.repository.findAll();
    }

    public Lead getLead(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteLead(Long id){
        repository.deleteById(id);
    }

    public Lead updateStatus(Long id, LeadStatus status){
        Lead lead = repository.findById(id).orElse(null);
        if(lead == null){ return null;}
        lead.setStatus(status);
//        lead.setStatus(status);
        repository.save(lead);
        return lead;
    }
}

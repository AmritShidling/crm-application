package com.lead.service.crm_lead_service.service;

import com.lead.service.crm_lead_service.DTO.LeadRequestDTO;
import com.lead.service.crm_lead_service.DTO.LeadResponseDTO;
import com.lead.service.crm_lead_service.exception.LeadNotFoundException;
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

    public LeadResponseDTO createLead(LeadRequestDTO lead){
        Lead toBeSaved = Lead.builder()
                .email(lead.getEmail())
                .phone(lead.getEmail())
                .name(lead.getName())
                .status(lead.getStatus())
                .customerId(lead.getCustomerId())
                .build();
        Lead saved =  repository.save(toBeSaved);
        return LeadResponseDTO.builder()
                .phone(saved.getPhone())
                .name(saved.getName())
                .id(saved.getId())
                .status(saved.getStatus())
                .customerId(saved.getCustomerId())
                .build();
    }

    public List<LeadResponseDTO> getAllLeads(){
        return this.repository.findAll().stream().map(
                this::mapToResponseDTO
        ).toList();
    }

    private LeadResponseDTO mapToResponseDTO(Lead lead){
        return LeadResponseDTO.builder()
                .id(lead.getId())
                .email(lead.getEmail())
                .phone(lead.getPhone())
                .name(lead.getName())
                .customerId(lead.getCustomerId())
                .status(lead.getStatus())
                .build();
    }

    public LeadResponseDTO getLead(Long id){
        Lead lead  = repository.findById(id).orElseThrow(()-> new LeadNotFoundException("Lead with ID "+ id + " not found"));
        return this.mapToResponseDTO(lead);
    }

    public void deleteLead(Long id){
        repository.deleteById(id);
    }

    public Lead updateStatus(Long id, LeadStatus status){
        Lead lead = repository.findById(id).orElseThrow(()-> new LeadNotFoundException("Lead with ID "+id+ " not found"));
        lead.setStatus(status);
        repository.save(lead);
        return lead;
    }
}

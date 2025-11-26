package com.lead.service.crm_lead_service.controller;

import com.lead.service.crm_lead_service.DTO.LeadRequestDTO;
import com.lead.service.crm_lead_service.DTO.LeadResponseDTO;
import com.lead.service.crm_lead_service.model.Lead;
import com.lead.service.crm_lead_service.model.LeadStatus;
import com.lead.service.crm_lead_service.service.LeadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    LeadService leadService;

    public LeadController(LeadService service){
        this.leadService = service;
    }

    @PostMapping
    public LeadResponseDTO createLead(@RequestBody LeadRequestDTO lead){
        return leadService.createLead(lead);
    }

    @GetMapping
    public List<LeadResponseDTO> getAllLeads(){
        return leadService.getAllLeads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadResponseDTO> getLead(@PathVariable Long id){
        LeadResponseDTO lead = leadService.getLead(id);
        return lead == null? ResponseEntity.notFound().build(): ResponseEntity.ok(lead);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Lead> updateStatus(@PathVariable Long id, @RequestParam LeadStatus status){
        LeadResponseDTO lead = leadService.getLead(id);
        if(lead == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(leadService.updateStatus(id, status));
    }
}

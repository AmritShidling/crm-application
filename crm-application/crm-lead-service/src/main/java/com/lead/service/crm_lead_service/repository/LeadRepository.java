package com.lead.service.crm_lead_service.repository;

import com.lead.service.crm_lead_service.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}

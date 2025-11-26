package com.lead.service.crm_lead_service.DTO;

import com.lead.service.crm_lead_service.model.LeadStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeadResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

    private LeadStatus status;

    private Long customerId;
}

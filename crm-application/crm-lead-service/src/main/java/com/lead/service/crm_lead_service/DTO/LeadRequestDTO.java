package com.lead.service.crm_lead_service.DTO;

import com.lead.service.crm_lead_service.model.LeadStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeadRequestDTO {
    @NotBlank(message = "Name can not be empty")
    private String name;
    @Email(message = "Provide valid email")
    private String email;
    @NotBlank
    private String phone;

    private LeadStatus status;

    private Long customerId;
}

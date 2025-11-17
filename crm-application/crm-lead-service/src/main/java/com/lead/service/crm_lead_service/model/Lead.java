package com.lead.service.crm_lead_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    private Long customerId;
}

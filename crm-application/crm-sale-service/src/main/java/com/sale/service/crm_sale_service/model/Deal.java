package com.sale.service.crm_sale_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long leadId;
    private String title;
    private Double amount;
    private LocalDate expectedCloseDate;

    @Enumerated(EnumType.STRING)
    private DealStage stage;

    @Enumerated(EnumType.STRING)
    private DealStatus status;
}

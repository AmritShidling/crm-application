package com.sale.service.crm_sale_service.repository;

import com.sale.service.crm_sale_service.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
}

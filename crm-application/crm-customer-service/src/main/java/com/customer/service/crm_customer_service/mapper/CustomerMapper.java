package com.customer.service.crm_customer_service.mapper;

import com.customer.service.crm_customer_service.DTO.CustomerCreateRequest;
import com.customer.service.crm_customer_service.DTO.CustomerResponseDTO;
import com.customer.service.crm_customer_service.DTO.CustomerUpdateRequest;
import com.customer.service.crm_customer_service.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerResponseDTO toResponseDTO(Customer customer);
    Customer toEntity(CustomerCreateRequest request);
}

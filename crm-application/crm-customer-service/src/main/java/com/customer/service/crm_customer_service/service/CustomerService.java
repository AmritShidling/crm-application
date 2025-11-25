package com.customer.service.crm_customer_service.service;

import com.customer.service.crm_customer_service.DTO.CustomerCreateRequest;
import com.customer.service.crm_customer_service.DTO.CustomerResponseDTO;
import com.customer.service.crm_customer_service.exception.CustomerNotFoundException;
import com.customer.service.crm_customer_service.mapper.CustomerMapper;
import com.customer.service.crm_customer_service.model.Customer;
import com.customer.service.crm_customer_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    public CustomerService(CustomerRepository repository, CustomerMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CustomerResponseDTO> getAllCustomers(){
        List<Customer> customers = repository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS = new ArrayList<>();
        for(Customer customer: customers)
            customerResponseDTOS.add(mapper.toResponseDTO(customer));
        return customerResponseDTOS;
    }

    public CustomerResponseDTO getCustomerById(Long id){

        return mapper.toResponseDTO( repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + id + " not found")));
    }

    public CustomerResponseDTO saveCustomer(CustomerCreateRequest customerRequest){
        Customer customer = mapper.toEntity(customerRequest);
        Customer saved = repository.save(customer);
        return mapper.toResponseDTO(saved);
    }

    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }
}

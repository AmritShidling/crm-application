package com.customer.service.crm_customer_service.controller;

import com.customer.service.crm_customer_service.DTO.CustomerCreateRequest;
import com.customer.service.crm_customer_service.DTO.CustomerResponseDTO;
import com.customer.service.crm_customer_service.model.Customer;
import com.customer.service.crm_customer_service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService service){
        this.customerService = service;
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id){
        CustomerResponseDTO customer = customerService.getCustomerById(id);
        return customer!= null? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerCreateRequest customer){
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @DeleteMapping
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}

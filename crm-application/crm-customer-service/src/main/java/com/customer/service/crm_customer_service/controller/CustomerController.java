package com.customer.service.crm_customer_service.controller;

import com.customer.service.crm_customer_service.model.Customer;
import com.customer.service.crm_customer_service.service.CustomerService;
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
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return customer!= null? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}

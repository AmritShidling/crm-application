package com.customer.service.crm_customer_service.service;

import com.customer.service.crm_customer_service.exception.CustomerNotFoundException;
import com.customer.service.crm_customer_service.model.Customer;
import com.customer.service.crm_customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer getCustomerById(Long id){

        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + id + " not found"));
    }

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }
}

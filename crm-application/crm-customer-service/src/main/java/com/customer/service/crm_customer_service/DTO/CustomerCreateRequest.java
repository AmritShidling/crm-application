package com.customer.service.crm_customer_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerCreateRequest {
    @NotBlank
    @Size(min = 2, message = "Invalid Name")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phone;
    private String company;
}

package com.customer.service.crm_customer_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerUpdateRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be at least 2 character long")
    private String name;
    @Email(message = "Not valid email")
    private String email;
    @NotBlank(message = "Phone Number required")
    private String phoneNumber;
    private String company;
}

package com.adserver.adrotator.service;

import com.adserver.adrotator.dto.CustomerDTO;

public interface CustomerService {
 public CustomerDTO getCustomerByEmailAndPassword(String email, String password);
    
} 
package com.adserver.adrotator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adserver.adrotator.dto.CustomerDTO;
import com.adserver.adrotator.service.CustomerService;



@RestController
@RequestMapping("/customers")  // Base path for the controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public CustomerDTO getByEmailAndPassword(@RequestParam String email,@RequestParam String password){
        return customerService.getCustomerByEmailAndPassword(email, password);
    }

}

package com.adserver.adrotator.dal;

import org.springframework.data.repository.CrudRepository;

import com.adserver.adrotator.model.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, Integer>{
    
}
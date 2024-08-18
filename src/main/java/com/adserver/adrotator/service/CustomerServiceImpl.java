package com.adserver.adrotator.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adserver.adrotator.dal.CustomerRepository;
import com.adserver.adrotator.dto.AdvertisementDTO;
import com.adserver.adrotator.dto.CustomerDTO;
import com.adserver.adrotator.model.Advertisement;
import com.adserver.adrotator.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRep;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO getCustomerByEmailAndPassword(String email, String password) {
        Optional<Customer> customerOpt = ((List<Customer>) customerRep.findAll()).stream()
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .findFirst();

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            // AdvertisementDTO dto = mapper.map(ad, AdvertisementDTO.class);

            return modelMapper.map(customer, CustomerDTO.class); // Convert Customer to CustomerDTO
        } else {
            throw new IllegalStateException("Customer not found for the provided email and password.");
        }
    }
}

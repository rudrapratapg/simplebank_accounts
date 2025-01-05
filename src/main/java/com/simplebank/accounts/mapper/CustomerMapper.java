package com.simplebank.accounts.mapper;

import com.simplebank.accounts.dto.CustomerDto;
import com.simplebank.accounts.entity.Customer;

public class CustomerMapper {

    /**
     * maps Customer to CustomerDto
     * @param customerDto
     * @param customer
     * @return
     */
    public static CustomerDto mapsToCustomerDto(CustomerDto customerDto, Customer customer) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    /**
     * maps CustomerDto to Customer
     * @param customerDto
     * @param customer
     * @return
     */
    public static Customer mapsToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}

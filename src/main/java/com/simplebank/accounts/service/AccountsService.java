package com.simplebank.accounts.service;

import com.simplebank.accounts.dto.CustomerDto;

public interface AccountsService {

    /**
     * @param customerDto CustomerDto
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String phoneNumber);

    boolean updateAccount(CustomerDto customerDto);

    void deleteAccount(String phoneNumber);

}

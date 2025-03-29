package com.simplebank.accounts.service.impl;


import com.simplebank.accounts.constants.AccountsConstants;
import com.simplebank.accounts.dto.AccountsDto;
import com.simplebank.accounts.dto.CustomerDto;
import com.simplebank.accounts.entity.Accounts;
import com.simplebank.accounts.entity.Customer;
import com.simplebank.accounts.exception.CustomerAlreadyExistsException;
import com.simplebank.accounts.exception.ResourceNotFoundException;
import com.simplebank.accounts.mapper.AccountsMapper;
import com.simplebank.accounts.mapper.CustomerMapper;
import com.simplebank.accounts.repository.AccountsRepository;
import com.simplebank.accounts.repository.CustomerRepository;
import com.simplebank.accounts.service.AccountsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto CustomerDto
     */
    @Override
    @Transactional
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapsToCustomer(customerDto, new Customer());
        customerRepository.findByMobileNumber(customer.getMobileNumber())
                .ifPresent(c -> {
                    throw new CustomerAlreadyExistsException("Customer already exists with mobile number: " + c.getMobileNumber());
                });
        customer.setCreatedBy(AccountsConstants.SYSTEM);
        customer.setCreatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);
        Accounts newAccount = createNewAccount(savedCustomer);
        accountsRepository.save(newAccount);
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts account = new Accounts();
        Long accNumber = 1000000000L + new Random().nextInt(900000000);
        account.setCustomerId(customer.getCustomerId());
        account.setAccountNumber(accNumber);
        account.setAccountType(AccountsConstants.SAVINGS);
        account.setBranchAddress(AccountsConstants.ADDRESS);
        account.setCreatedBy(AccountsConstants.SYSTEM);
        account.setCreatedAt(LocalDateTime.now());
        return account;
    }

    /**
     * @param mobileNumber String
     * @return Accounts details based on a given mobileNumber
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDto customerDto = CustomerMapper.mapsToCustomerDto(new CustomerDto(), customer);
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
        return customerDto;
    }

    @Override
    @Transactional
    public boolean updateAccount(CustomerDto customerDto) {
        if(customerDto!=null){
            Accounts account = accountsRepository.findByAccountNumber(customerDto.getAccountsDto().getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber", customerDto.getAccountsDto().getAccountNumber().toString()));
            AccountsMapper.mapToAccounts(customerDto.getAccountsDto(), account);
            account = accountsRepository.save(account);
            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));
            CustomerMapper.mapsToCustomer(customerDto, customer);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteAccount(String phoneNumber) {
        boolean deleted=false;
        try {
            Customer customer = customerRepository.findByMobileNumber(phoneNumber)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", phoneNumber));
            Long customerId = customer.getCustomerId();
            Accounts account = accountsRepository.findByCustomerId(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customerId.toString()));
            accountsRepository.delete(account);
            customerRepository.delete(customer);
            deleted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }
}

package com.simplebank.accounts.mapper;

import com.simplebank.accounts.dto.AccountsDto;
import com.simplebank.accounts.dto.CustomerDto;
import com.simplebank.accounts.entity.Accounts;

public class AccountsMapper {

    /**
     * Maps Accounts to AccountsDto
     * @param accounts
     * @param accountsDto
     * @return
     */
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    /**
     * Maps AccountsDto to Accounts
     * @param accountsDto
     * @param accounts
     * @return
     */
    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}

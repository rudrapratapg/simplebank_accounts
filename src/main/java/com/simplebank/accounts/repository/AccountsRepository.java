package com.simplebank.accounts.repository;

import com.simplebank.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    Optional<Accounts> findByAccountNumber(Long accountNumber);

    /**
     * @Transactional tells the Spring data framework that this method is going to be part of a transaction.
     * @Modifying tells the Spring data framework that this method is going to modify the data in DB, so it should be executed in a transaction.
     * When Sping Data JPA runs teh query inside transaction, and if some error happens at runtime, any partial change in data,
     * transaction will rollback the transaction.
     *
     * these annotations need to be put only on the custom created methods, not on the methods provided by the JpaRepository.
     * This method deletes the account details based on the customerId.
     * @param customerId
     */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}

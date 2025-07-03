package com.techhub.BankApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.BankApp.Entities.Account;
import com.techhub.BankApp.Entities.AccountType;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // This interface will automatically have methods for CRUD operations
    // such as save, findById, findAll, deleteById, etc.
    // Additional custom query methods can be defined here if needed.
    List<Account> findByAccountType(AccountType accountType);

    List<Account> findByAccountHolderName(String accountHolderName);
    List<Account> findByAccountNumber(String accountNumber);
    List<Account> findByBalanceGreaterThan(double balance);
    List<Account> findByBalanceLessThan(double balance);

}

package com.techhub.BankApp.Interfaces.Services;

import java.util.List;

import com.techhub.BankApp.Entities.Account;

public interface IAccountService {

    void createAccount(String accountNumber, String accountHolderName, double initialBalance, Long accountTypeId);

    Account getAccountById(Long id);

    void updateAccount(Long id, String accountNumber, String accountHolderName, double balance, Long accountTypeId);

    void deleteAccount(Long id);

    List<Account> getAllAccounts();

    List<Account> getAccountsByType(Long accountTypeId);

    List<Account> getAccountsByHolderName(String accountHolderName);

    List<Account> getAccountsByNumber(String accountNumber);

}

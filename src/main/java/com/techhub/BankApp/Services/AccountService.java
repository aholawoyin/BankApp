package com.techhub.BankApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techhub.BankApp.Entities.Account;
import com.techhub.BankApp.Interfaces.Services.IAccountService;
import com.techhub.BankApp.Repositories.AccountRepository;
import com.techhub.BankApp.Repositories.AccountTypeRepository;

@Service
public class AccountService  implements IAccountService{

    private final AccountTypeRepository accountTypeRepository;
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository, AccountTypeRepository accountTypeRepository) {
        this.accountRepository = accountRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    // Add methods to handle account operations such as create, update, delete, and retrieve accounts
    // Example method to create an account
    @Override
    public void createAccount(String accountNumber, String accountHolderName, double initialBalance, Long accountTypeId) {
        var accountType = accountTypeRepository.findById(accountTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Account type not found with ID: " + accountTypeId));
        var account = new Account(accountNumber, accountHolderName, initialBalance, accountType);
        accountRepository.save(account);
    }

    // Example method to retrieve an account by ID
    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
    }

    // Example method to update an account
    @Override
    public void updateAccount(Long id, String accountNumber, String accountHolderName, double balance, Long accountTypeId) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
        account.setAccountNumber(accountNumber);
        account.setAccountHolderName(accountHolderName);
        account.setBalance(balance);
        var accountType = accountTypeRepository.findById(accountTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Account type not found with ID: " + accountTypeId));
        account.setAccountType(accountType);
        accountRepository.save(account);
    }

    // Example method to delete an account
    @Override
    public void deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Account not found with ID: " + id);
        }
    }

    // Example method to retrieve all accounts
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Example method to retrieve accounts by account type
    @Override
    public List<Account> getAccountsByType(Long accountTypeId) {
        var accountType = accountTypeRepository.findById(accountTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Account type not found with ID: " + accountTypeId));
        return accountRepository.findByAccountType(accountType);
    }
    // Example method to retrieve accounts by account holder name
    @Override
    public List<Account> getAccountsByHolderName(String accountHolderName) {
        return accountRepository.findByAccountHolderName(accountHolderName);
    }

    // Example method to retrieve accounts by account number
    @Override
    public List<Account> getAccountsByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

}

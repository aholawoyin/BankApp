package com.techhub.BankApp.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.BankApp.Entities.AccountType;
import com.techhub.BankApp.Services.AccountTypeService;

@RestController
@RequestMapping("/account-types")
public class AccountTypeController {

    private final AccountTypeService accountTypeService;
    private final Logger logger = LoggerFactory.getLogger(AccountTypeController.class);
    // For example, you might have methods to create, update, delete, and retrieve account types

    public AccountTypeController(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }

    // Example method to create a new account type
    @PostMapping
    public void createAccountType(@RequestBody AccountType accountType) {
        accountTypeService.createAccountType(accountType);
    }

    // Example method to retrieve all account types
    @GetMapping
    public List<AccountType> getAllAccountTypes() {
        // Logic to retrieve all account types
        return accountTypeService.getAllAccountTypes();
    }

    // Example method to retrieve an account type by ID
    @GetMapping("/{id}")
    public AccountType getAccountTypeById(@PathVariable Long id) {
        // Logic to retrieve an account type by ID
        return accountTypeService.getAccountTypeById(id);
    }

    // Example method to update an existing account type
    @PutMapping("/{id}")
    public void updateAccountType(@RequestBody AccountType accountType,@PathVariable Long id) {
        // Logic to update an existing account type
        logger.info("Updating account type with ID: {}", id);
        logger.info(accountType.toString());
        if (accountType == null || id == null) {
            throw new IllegalArgumentException("AccountType entity and ID must not be null");
        }

        accountTypeService.updateAccountType(accountType, id);
    }

    // Example method to delete an account type by ID
    @DeleteMapping("/{id}")
    public void deleteAccountType(@PathVariable Long id) {
        accountTypeService.deleteAccountType(id);
    }

}

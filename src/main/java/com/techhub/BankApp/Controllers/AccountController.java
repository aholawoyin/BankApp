package com.techhub.BankApp.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.BankApp.DTOs.AccountDtos.CreateAccountDto;
import com.techhub.BankApp.DTOs.AccountDtos.UpdateAccountDto;
import com.techhub.BankApp.Entities.Account;
import com.techhub.BankApp.Interfaces.Services.IAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final IAccountService accountService;
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        logger.info("Retrieving account with ID: {}", id);
        return accountService.getAccountById(id);
    }

    @PostMapping
    public void createAccount(@RequestBody CreateAccountDto accountDto) {
        accountService.createAccount(accountDto.accountNumber, accountDto.accountHolderName, accountDto.balance, accountDto.AccountTypeId);
    }

    @PutMapping("/{id}")
    public void updateAccount(@RequestBody UpdateAccountDto updateAccountDto, @PathVariable Long id) {
        accountService.updateAccount(updateAccountDto.id, updateAccountDto.accountNumber,updateAccountDto.accountHolderName, updateAccountDto.balance,updateAccountDto.accountTypeId);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}

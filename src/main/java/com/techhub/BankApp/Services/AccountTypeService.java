package com.techhub.BankApp.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.techhub.BankApp.Entities.AccountType;
import com.techhub.BankApp.Repositories.AccountTypeRepository;

@Service
public class AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;
    private final Logger logger = LoggerFactory.getLogger(AccountTypeService.class);

    public AccountTypeService(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<AccountType> getAllAccountTypes() {
        // Logic to retrieve all account types
        return accountTypeRepository.findAll();
    }

    public AccountType getAccountTypeById(Long id) {
        // Logic to retrieve an account type by ID
        return accountTypeRepository.findById(id).orElse(null);
    }

    public void createAccountType(AccountType entity) {
        // Logic to create a new account type
        // This could involve creating an AccountType entity and saving it to the repository
        AccountType accountType = new AccountType(entity.getTypeName(), entity.getDescription());
        accountTypeRepository.save(accountType);
    }

    public void updateAccountType(AccountType entity, Long id) {
        // Logic to update an existing account type

        logger.info("Updating account type with ID: {}", id);
        if (entity == null || id == null) {
            throw new IllegalArgumentException("AccountType entity and ID must not be null");
        }   
        // Find the existing account type by ID
        logger.info(entity.toString());
        AccountType accountType = accountTypeRepository.findById(id).orElse(null);
        if (accountType != null) {
            accountType.setTypeName(entity.getTypeName());
            accountType.setDescription(entity.getDescription());
            accountTypeRepository.save(accountType);
        }
    }

    public void deleteAccountType(Long id) {
        // Logic to delete an account type by ID
        if (accountTypeRepository.existsById(id)) {
            accountTypeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Account type with ID " + id + " does not exist.");
        }
    }

}

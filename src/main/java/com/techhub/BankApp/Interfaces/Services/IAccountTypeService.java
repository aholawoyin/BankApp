package com.techhub.BankApp.Interfaces.Services;

import java.util.List;

import com.techhub.BankApp.DTOs.AccountTypeDtos.CreateAccountTypeDto;
import com.techhub.BankApp.DTOs.AccountTypeDtos.UpdateAccountTypeDto;
import com.techhub.BankApp.Entities.AccountType;

public interface IAccountTypeService {

    List<AccountType> getAllAccountTypes();

    AccountType getAccountTypeById(Long id);

    void createAccountType(CreateAccountTypeDto entity);

    void updateAccountType(UpdateAccountTypeDto entity, Long id);

    void deleteAccountType(Long id);

}

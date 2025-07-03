package com.techhub.BankApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.BankApp.Entities.AccountType;

@Repository
public interface  AccountTypeRepository extends  JpaRepository<AccountType, Long> {
    // This interface will automatically have methods for CRUD operations
    // such as save, findById, findAll, deleteById, etc.
    // Additional custom query methods can be defined here if needed.

}

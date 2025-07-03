package com.techhub.BankApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.BankApp.Entities.Transaction;

@Repository
public interface  TransactionRepository extends JpaRepository<Transaction, Long> {
    // This interface will automatically have methods for CRUD operations
    // such as save, findById, findAll, deleteById, etc.
    // Additional custom query methods can be defined here if needed. 
    

}

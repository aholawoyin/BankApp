package com.techhub.BankApp.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techhub.BankApp.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // This interface will automatically have methods for CRUD operations
    // such as save, findById, findAll, deleteById, etc.
    // Additional custom query methods can be defined here if needed.
    Optional<List<Customer>> findByAccountId(Long accountId);

}

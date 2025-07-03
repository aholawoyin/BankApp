package com.techhub.BankApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techhub.BankApp.Entities.Transaction;
import com.techhub.BankApp.Repositories.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Add methods to handle transaction operations such as create, update, delete, and retrieve transactions
    // Example method to create a transaction
    public void createTransaction(String transactionType, double amount, String transactionDate, String description) {
        // Logic to create a new transaction
        // This could involve creating a Transaction entity and saving it to the repository
        Transaction transaction = new Transaction(transactionType, amount, transactionDate, description);
        transactionRepository.save(transaction);
    }

    // Example method to retrieve a transaction by ID
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found with ID: " + id));
    }

    // Example method to update a transaction
    public void updateTransaction(Long id, String transactionType, double amount, String transactionDate,
            String description) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found with ID: " + id));
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transaction.setTransactionDate(transactionDate);
        transaction.setDescription(description);
        transactionRepository.save(transaction);
    }

    // Example method to delete a transaction
    public void deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Transaction not found with ID: " + id);
        }
    }

    // Example method to retrieve all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}

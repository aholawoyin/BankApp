package com.techhub.BankApp.Interfaces.Services;

import java.util.List;

import com.techhub.BankApp.Entities.Transaction;

public interface ITransactionService {

    void createTransaction(String transactionType, double amount, String transactionDate, String description);

    Transaction getTransactionById(Long id);

    void updateTransaction(Long id, String transactionType, double amount, String transactionDate, String description);

    void deleteTransaction(Long id);

    List<Transaction> getAllTransactions();

}

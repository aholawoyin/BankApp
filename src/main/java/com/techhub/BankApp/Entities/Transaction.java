package com.techhub.BankApp.Entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String transactionType; // e.g., "DEPOSIT", "WITHDRAWAL", "TRANSFER"
    @Column(nullable = false)
    private double amount; // Amount of the transaction
    @Column(nullable = false)
    private String transactionDate; // Date in ISO format (e.g., "2023-10-01T12:00:00Z")
    @Column(length = 255)
    private String description; // Optional description of the transaction

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt; // Timestamp of when the transaction was created
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private String updatedAt; // Timestamp of when the transaction was last updated

    @ManyToMany(mappedBy = "transactions")
    private List<Account> accounts; // List of accounts associated with the transaction

    @ManyToMany
    @JoinTable(
            name = "customer_transaction",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers; // Set of customers associated with the transaction

    // Constructors
    public Transaction() {
    }

    public Transaction(String transactionType, double amount, String transactionDate, String description) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "id=" + id
                + ", transactionType='" + transactionType + '\''
                + ", amount=" + amount
                + ", transactionDate='" + transactionDate + '\''
                + ", description='" + description + '\''
                + ", createdAt='" + createdAt + '\''
                + ", updatedAt='" + updatedAt + '\''
                + ", accounts=" + accounts
                + ", customers=" + customers
                + '}';
    }

}

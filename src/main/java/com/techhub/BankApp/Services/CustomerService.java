package com.techhub.BankApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techhub.BankApp.Entities.Customer;
import com.techhub.BankApp.Interfaces.Services.ICustomerService;
import com.techhub.BankApp.Repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Add methods to handle customer operations such as create, update, delete, and retrieve customers
    // Example method to create a customer  
    @Override
    public void createCustomer(String name, String email, String phoneNumber, String address) {
        // Logic to create a new customer
        // This could involve creating a Customer entity and saving it to the repository
        Customer customer = new Customer(name, email, phoneNumber, address);
        customerRepository.save(customer);
    }

    // Example method to retrieve a customer by ID
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + id));
    }

    // Example method to update a customer
    @Override
    public void updateCustomer(Long id, String name, String email, String phoneNumber, String address) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + id));
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customerRepository.save(customer);
    }

    // Example method to delete a customer
    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Customer not found with ID: " + id);
        }
    }

    // Example method to retrieve all customers
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    // Example method to retrieve customers by account
    @Override
    public List<Customer> getCustomersByAccount(Long accountId) {
        return customerRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("No customers found for account ID: " + accountId));
    }

}

package com.techhub.BankApp.Interfaces.Services;

import java.util.List;

import com.techhub.BankApp.Entities.Customer;

public interface ICustomerService {

    void createCustomer(String name, String email, String phoneNumber, String address);

    Customer getCustomerById(Long id);

    void updateCustomer(Long id, String name, String email, String phoneNumber, String address);

    void deleteCustomer(Long id);

    List<Customer> getAllCustomers();

    List<Customer> getCustomersByAccount(Long accountId);

}

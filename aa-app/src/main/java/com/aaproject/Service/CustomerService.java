package com.aaproject.Service;

import com.aaproject.Entity.Customer;

import java.util.Collection;
public interface CustomerService {
    Collection<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void removeCustomerById(int id);

    void updateCustomer(Customer updatedCustomer);

    void createNewCustomer(Customer newCustomer);
}

package com.aaproject.Service;

import com.aaproject.Entity.Customer;
import com.aaproject.Repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
@Qualifier("mysqldata")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<Integer, Customer>() {
            {
                put(1, new Customer(1,"ant@gmail.com","Anthony", "Coudrey","1.1.1", 36.12, -115.07, "2015-01-22 20:38:31", "2015-01-22 20:38:31"));
                put(2, new Customer(2,"Bnt@gmail.com","Anthony", "Coudrey","1.1.1",  36.12, -115.07, "2015-01-22 20:38:31", "2015-01-22 20:38:31"));
                put(3, new Customer(3,"Cnt@gmail.com","Anthony", "Coudrey","1.1.1",  36.12, -115.07, "2015-01-22 20:38:31", "2015-01-22 20:38:31"));
            }
        };
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRespository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return this.customers.get(id);
    }

    @Override
    public void removeCustomerById(int id) {
        this.customers.remove(id);
    }

    @Override
    public void updateCustomer(Customer updatedCustomer) {
        Customer c = customers.get(updatedCustomer.getId());
        c.setFirstName(updatedCustomer.getFirstName());
        c.setLastName(updatedCustomer.getLastName());
        c.setIp(updatedCustomer.getIp());
        c.setEmail(updatedCustomer.getEmail());
        c.setLatitude(updatedCustomer.getLatitude());
        c.setLongitude(updatedCustomer.getLongitude());
        c.setUpdatedAt(updatedCustomer.getUpdatedAt());
        c.setCreatedAt(updatedCustomer.getCreatedAt());
        customers.put(updatedCustomer.getId(), c);
    }

    @Override
    public void createNewCustomer(Customer newCustomer) {

        customerRespository.save(newCustomer);

    }
}

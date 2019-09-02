package com.aaproject.Controller;

import com.aaproject.Entity.Customer;
import com.aaproject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewCustomer(@RequestBody Customer newCustomer) {
        customerService.createNewCustomer(newCustomer);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestBody Customer updatedCustomer) {
        customerService.updateCustomer(updatedCustomer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void removeCustomerById(@PathVariable("id") int id) {
        customerService.removeCustomerById(id);
    }
}

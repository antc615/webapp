package com.aaproject.Repository;

import com.aaproject.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRespository extends CrudRepository<Customer, Integer> {

    ArrayList<Customer> findAll();

}
package com.codegym.demo.service;

import com.codegym.demo.model.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void deleteById(Integer id);
    void save(Customer customer);
}

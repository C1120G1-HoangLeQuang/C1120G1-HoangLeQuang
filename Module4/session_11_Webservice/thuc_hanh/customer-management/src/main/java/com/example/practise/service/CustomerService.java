package com.example.practise.service;

import com.example.practise.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer findById(Long id);
    void save (Customer customer);
    void deleteById(Long id);
}

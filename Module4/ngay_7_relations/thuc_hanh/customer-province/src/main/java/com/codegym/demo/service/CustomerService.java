package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void deleteById(Integer id);
    void save(Customer customer);
    Page<Customer> findAllByFirstNameContaining (String firstName, Pageable pageable);
}

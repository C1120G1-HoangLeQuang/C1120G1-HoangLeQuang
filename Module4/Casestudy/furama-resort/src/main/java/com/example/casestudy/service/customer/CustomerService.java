package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(String id);
    Customer findByCusId(String id);
    void deleteById(String id);
    void deleteCustomerByCusId(String id);
    void deleteByCusId(String id);
    void save(Customer customer);
    Page<Customer> findAllByCusNameContaining(String name, Pageable pageable);
}

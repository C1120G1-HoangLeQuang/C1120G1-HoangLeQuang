package com.example.casestudy.service.customer.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.CustomerRepository;
import com.example.casestudy.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByCusNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByCusNameContaining(name, pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findByCusId(String id) {
        return customerRepository.findByCusId(id);
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteCustomerByCusId(String id) {
        customerRepository.deleteCustomerByCusId(id);
    }

    @Override
    public void deleteByCusId(String id) {
        customerRepository.deleteByCusId(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}

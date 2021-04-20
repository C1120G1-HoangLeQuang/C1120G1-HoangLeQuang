package com.example.casestudy.service.customer.impl;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.repository.customer.CustomerTypeRepository;
import com.example.casestudy.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }
}

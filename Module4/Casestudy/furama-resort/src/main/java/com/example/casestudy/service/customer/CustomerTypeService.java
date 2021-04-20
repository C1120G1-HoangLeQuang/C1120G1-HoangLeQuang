package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {

    List<CustomerType> findAll();
    CustomerType findById(Integer id);
    void deleteById(Integer id);
    void save(CustomerType customerType);
}

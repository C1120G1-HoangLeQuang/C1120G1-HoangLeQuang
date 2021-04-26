package com.example.casestudy.service.services;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;

import java.util.List;

public interface ServiceServices {

    Page<Service> findAll(Pageable pageable);
    List<Service> findAll();
    Service findById(String id);
    Service findBySerId(String id);
    void deleteById(String id);
    void save(Service service);
    void validateServiceIdExist(Service service, Errors errors);
}

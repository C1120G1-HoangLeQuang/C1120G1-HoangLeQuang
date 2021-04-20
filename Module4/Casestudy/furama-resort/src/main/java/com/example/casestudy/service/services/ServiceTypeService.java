package com.example.casestudy.service.services;

import com.example.casestudy.model.service.ServiceType;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceType> findAll();
    ServiceType findById(Integer id);
}

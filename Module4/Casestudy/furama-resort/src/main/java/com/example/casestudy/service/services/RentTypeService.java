package com.example.casestudy.service.services;

import com.example.casestudy.model.service.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    RentType findById(Integer id);
}

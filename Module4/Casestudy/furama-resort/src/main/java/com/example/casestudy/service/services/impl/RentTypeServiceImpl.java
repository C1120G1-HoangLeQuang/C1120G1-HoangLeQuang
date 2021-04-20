package com.example.casestudy.service.services.impl;

import com.example.casestudy.model.service.RentType;
import com.example.casestudy.repository.services.RentTypeRepository;
import com.example.casestudy.service.services.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}

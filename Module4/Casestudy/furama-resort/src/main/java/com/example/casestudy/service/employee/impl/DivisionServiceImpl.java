package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.Division;
import com.example.casestudy.repository.employee.DivisionRepository;
import com.example.casestudy.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(Integer id) {
        return divisionRepository.findById(id).orElse(null);
    }
}

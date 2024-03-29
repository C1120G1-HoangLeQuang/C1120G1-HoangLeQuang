package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.repository.employee.EducationDegreeRepository;
import com.example.casestudy.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Integer id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }
}

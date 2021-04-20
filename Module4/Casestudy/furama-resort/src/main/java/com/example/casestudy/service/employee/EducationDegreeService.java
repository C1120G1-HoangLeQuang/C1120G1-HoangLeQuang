package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.model.employee.Position;

import java.util.List;

public interface EducationDegreeService {

    List<EducationDegree> findAll();
    EducationDegree findById(Integer id);
}

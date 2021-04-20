package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.Division;
import com.example.casestudy.model.employee.Position;

import java.util.List;

public interface DivisionService {

    List<Division> findAll();
    Division findById(Integer id);
}

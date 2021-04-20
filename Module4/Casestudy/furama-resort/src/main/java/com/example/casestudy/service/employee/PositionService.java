package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.Position;

import java.util.List;

public interface PositionService {

    List<Position> findAll();
    Position findById(Integer id);
}

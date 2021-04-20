package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.Position;
import com.example.casestudy.repository.employee.PositionRepository;
import com.example.casestudy.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return positionRepository.findById(id).orElse(null);
    }
}

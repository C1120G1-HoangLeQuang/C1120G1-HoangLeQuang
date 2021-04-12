package com.example.exercise.service.impl;

import com.example.exercise.model.MyCounter;
import com.example.exercise.repository.MyCounterRepository;
import com.example.exercise.service.MyCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyCounterServiceImpl implements MyCounterService {
    @Autowired
    MyCounterRepository myCounterRepository;

    @Override
    public int VisitTurnNumber(Integer id) {
        MyCounter myCounter = myCounterRepository.getOne(id);
        return myCounter.getCount();
    }

    @Override
    public void getVisitTurn(Integer id) {
        MyCounter myCounter = myCounterRepository.getOne(id);
        myCounter.setCount(myCounter.getCount() + 1);
        myCounterRepository.save(myCounter);
    }
}

package com.example.practise.service;

import com.example.practise.model.Smartphone;

public interface SmartphoneService {

    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone smartphone);
    Smartphone deleteById(Integer id);
}

package com.example.practise.service.impl;

import com.example.practise.model.Smartphone;
import com.example.practise.repository.SmartphoneRepository;
import com.example.practise.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone deleteById(Integer id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}

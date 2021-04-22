package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.AttachService;
import com.example.casestudy.repository.contract.AttachServiceRepository;
import com.example.casestudy.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}

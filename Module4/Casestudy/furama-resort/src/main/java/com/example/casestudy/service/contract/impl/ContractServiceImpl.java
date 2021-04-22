package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.contract.ContractRepository;
import com.example.casestudy.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }
}

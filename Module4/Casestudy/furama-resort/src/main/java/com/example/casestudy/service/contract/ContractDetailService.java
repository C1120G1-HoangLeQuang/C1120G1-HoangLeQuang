package com.example.casestudy.service.contract;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {

    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
    List<ContractDetail> findAllByContract(Contract contract);
}

package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.repository.contract.ContractDetailRepository;
import com.example.casestudy.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByContract(Contract contract) {
        return contractDetailRepository.findAllByContract(contract);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        int newQuantity = Integer.parseInt(contractDetail.getQuantity());
        for (ContractDetail conDetail : findAll()) {
            if (conDetail.getContract().getConId().equals(contractDetail.getContract().getConId())
            && conDetail.getAttachService().getAttachSerId().equals(contractDetail.getAttachService().getAttachSerId())) {
                contractDetail.setConDetailId(conDetail.getConDetailId());
                int conQty = Integer.parseInt(conDetail.getQuantity());
                contractDetail.setQuantity(conQty + newQuantity + "");
                break;
            }
        }
        contractDetailRepository.save(contractDetail);
    }
}

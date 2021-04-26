package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.repository.contract.ContractRepository;
import com.example.casestudy.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.Validate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@Component
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contract.setConTotal(calculateTotal(contract));
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> getCustomerByEndDate(String inputDate, Pageable pageable) {
        return contractRepository.getCustomerByEndDate(inputDate, pageable);
    }

    @Override
    public Page<Contract> getListContractByName(String cusName, String inputDate, Pageable pageable) {
        return contractRepository.getListContractByName(cusName,inputDate, pageable);
    }

    @Override
    public void deleteById(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public String calculateTotal(Contract contract) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate;
        Date checkOutDate;
        double totalMoney = 0;
        double totalAttach = 0;
        long getDiff;
        int totalDate = 0;
        try {
            checkInDate = dateFormat.parse(contract.getConStartDate());
            checkOutDate = dateFormat.parse(contract.getConEndDate());
            getDiff = checkOutDate.getTime() - checkInDate.getTime();
            totalDate = (int) TimeUnit.MILLISECONDS.toDays(getDiff);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        double serviceCost = Double.parseDouble(contract.getService().getSerCost());
        totalMoney = totalDate * serviceCost;

        if (contract.getConId() != null){
            Set<ContractDetail> contractDetailSet = contract.getContractDetails();
            if (!contractDetailSet.isEmpty()) { // co the su dung contractDetailSet != null(cach 2)
                for (ContractDetail conDetail : contractDetailSet) {
                    Double attachCost = Double.parseDouble(conDetail.getAttachService().getAttachSerCost());
                    Double detailQuantity = Double.parseDouble(conDetail.getQuantity());
                    totalAttach += (attachCost * detailQuantity);
                }
            }
        }

        totalMoney += totalAttach;
        return totalMoney+"";
    }

    // !null = khong co du lieu o vung nho heap
    // isEmpty = khong co du lieu trong database de check
}

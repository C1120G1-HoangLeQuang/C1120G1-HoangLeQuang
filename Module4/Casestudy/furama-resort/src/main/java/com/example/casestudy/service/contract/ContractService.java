package com.example.casestudy.service.contract;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {

    Page<Contract> findAll(Pageable pageable);
    void save(Contract contract);
    Contract findById(Integer id);
    void deleteById(Integer id);
    Page<Contract> getCustomerByEndDate(String inputDate, Pageable pageable);
    Page<Contract> getListContractByName(String cusName, String inputDate, Pageable pageable);
    String calculateTotal(Contract contract);
    void validateDateContract(Object object, Error error);
}

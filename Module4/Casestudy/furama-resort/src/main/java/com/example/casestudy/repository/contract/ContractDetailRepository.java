package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    List<ContractDetail> findAllByContract(Contract contract);
}

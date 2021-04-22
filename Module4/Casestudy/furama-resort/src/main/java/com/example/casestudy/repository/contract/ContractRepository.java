package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    Page<Contract> findAll(Pageable pageable);
}

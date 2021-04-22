package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    Page<Contract> findAll(Pageable pageable);

   @Query(
           value="select * from contract where contract_end_date >= ?1",
           nativeQuery = true)
   Page<Contract> getCustomerByEndDate(String inputDate, Pageable pageable);
    @Query(
            value=  "select * from contract " +
                    "inner join customer on customer.customer_id = contract.customer_id " +
                    "where customer.customer_name like ?1 and contract_end_date >= ?2",
            nativeQuery = true)
   Page<Contract> getListContractByName(String cusName, String inputDate, Pageable pageable);
}
package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);
    Customer findByCusId(String id);
    void deleteCustomerByCusId(String id);
    void deleteByCusId(String id);
    Page<Customer> findAllByCusNameContaining(String name, Pageable pageable);
}

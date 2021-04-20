package com.example.casestudy.repository.services;

import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

    Page<Service> findAll(Pageable pageable);
    Service findBySerId(String id);
}

package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);

    @Query(value = "select *" +
            " from employee " +
            "where concat(employee_name , employee_address) like %?1%", nativeQuery = true)
    Page<Employee> findByEmNameContaining(String name, Pageable pageable);


}

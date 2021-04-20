package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByEmNameContaining(String name, Pageable pageable);
    Employee findById(Integer id);
    void save(Employee employee);
    void deleteById(Integer id);
}

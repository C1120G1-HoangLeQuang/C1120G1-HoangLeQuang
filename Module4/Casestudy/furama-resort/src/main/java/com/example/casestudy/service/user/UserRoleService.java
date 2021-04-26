package com.example.casestudy.service.user;

import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.model.employee.User;
import com.example.casestudy.model.user.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> findByUser(User user);
    List<UserRole> findAll();
    void save(UserRole userRole);
}

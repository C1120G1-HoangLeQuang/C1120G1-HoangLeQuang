package com.example.casestudy.service.user.impl;

import com.example.casestudy.model.employee.User;
import com.example.casestudy.model.user.UserRole;
import com.example.casestudy.repository.user.UserRoleRepository;
import com.example.casestudy.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findByUser(User user) {
        return userRoleRepository.findByUser(user);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}

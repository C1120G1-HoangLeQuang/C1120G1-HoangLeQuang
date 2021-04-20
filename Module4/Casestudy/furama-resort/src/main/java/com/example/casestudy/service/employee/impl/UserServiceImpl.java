package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.User;
import com.example.casestudy.repository.employee.UserRepository;
import com.example.casestudy.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

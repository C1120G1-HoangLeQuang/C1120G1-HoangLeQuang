package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.User;
import com.example.casestudy.repository.employee.UserRepository;
import com.example.casestudy.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User createNewUser(String username, String password) {
        List<User> userList = findAll();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return null;
            }
        }
        User user = new User(username, hashPassword, true);
        save(user);
        return user;
    }


}

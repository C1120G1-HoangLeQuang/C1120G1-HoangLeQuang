package com.example.casestudy.repository.user;

import com.example.casestudy.model.employee.User;
import com.example.casestudy.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUser(User user);
}

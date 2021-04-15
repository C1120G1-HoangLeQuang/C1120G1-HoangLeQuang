package com.example.prastice.repository;

import com.example.prastice.model.AppRole;
import com.example.prastice.model.AppUser;
import com.example.prastice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}

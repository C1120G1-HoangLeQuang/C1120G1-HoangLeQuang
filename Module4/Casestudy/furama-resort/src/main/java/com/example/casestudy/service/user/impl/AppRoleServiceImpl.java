package com.example.casestudy.service.user.impl;

import com.example.casestudy.model.user.AppRole;
import com.example.casestudy.repository.user.AppRoleRepository;
import com.example.casestudy.service.user.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements AppRoleService {

    @Autowired
    AppRoleRepository appRoleRepository;

    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }
}

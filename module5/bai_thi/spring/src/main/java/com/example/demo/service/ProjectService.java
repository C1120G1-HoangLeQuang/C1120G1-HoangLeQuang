package com.example.demo.service;

import com.example.demo.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Integer id);
    void save(Project project);
    void deleteById(Integer id);
}

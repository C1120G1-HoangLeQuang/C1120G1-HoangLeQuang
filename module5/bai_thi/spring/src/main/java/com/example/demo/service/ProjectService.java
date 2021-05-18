package com.example.demo.service;

import com.example.demo.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Integer id);
    void save(Project project);
    void deleteById(Integer id);
    List<Project> searchByStudent(String student, String teacher);
    List<Project> searchByTeacher(String teacher);
}

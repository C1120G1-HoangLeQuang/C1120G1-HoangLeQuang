package com.example.demo.service.impl;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplement implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> searchByStudent(String student, String teacher) {
        return projectRepository.searchByStudent(student, teacher);
    }

    @Override
    public List<Project> searchByTeacher(String teacher) {
        return projectRepository.searchByTeacher(teacher);
    }
}

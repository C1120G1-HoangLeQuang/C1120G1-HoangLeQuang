package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/home/")
    public ResponseEntity<List<Project>> getListProject() {
        List<Project> projectList = this.projectService.findAll();
        if (projectList.isEmpty()) {
            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
    }

    @PutMapping("/home/edit/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Integer id, @RequestBody Project project) {
        Project currentProject = this.projectService.findById(id);
        if (currentProject == null) {
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
        currentProject.setNameStudent(project.getNameStudent());
        currentProject.setNameGroup(project.getNameGroup());
        currentProject.setNameProject(project.getNameProject());
        currentProject.setNameTeacher(project.getNameTeacher());
        currentProject.setEmail(project.getEmail());
        currentProject.setPhone(project.getPhone());
        return new ResponseEntity<Project>(currentProject, HttpStatus.OK);
    }

    @DeleteMapping("/home/edit/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable("id") Integer id) {
        Project project = this.projectService.findById(id);
        if (project == null) {
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
        this.projectService.deleteById(id);
        return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
    }
}

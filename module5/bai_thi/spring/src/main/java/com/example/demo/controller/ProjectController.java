package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/home")
    public ResponseEntity<List<Project>> getListProject() {
        List<Project> projectList = this.projectService.findAll();
        if (projectList.isEmpty()) {
            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
    }

    @GetMapping(value = "/home/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProject(@PathVariable("id") Integer id) {
        Project project = this.projectService.findById(id);
        if (project == null) {
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @PostMapping("/home/create")
    public ResponseEntity<Void> createProject(@RequestBody Project project, UriComponentsBuilder builder) {
        this.projectService.save(project);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("home/create/{id}").buildAndExpand(project.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/home/edit/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") Integer id, @Valid @RequestBody Project project,
                                                 BindingResult bindingResult) {
        Project currentProject = this.projectService.findById(id);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }

        if (currentProject == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            currentProject.setNameStudent(project.getNameStudent());
            currentProject.setNameGroup(project.getNameGroup());
            currentProject.setNameProject(project.getNameProject());
            currentProject.setNameTeacher(project.getNameTeacher());
            currentProject.setEmail(project.getEmail());
            currentProject.setPhone(project.getPhone());
            this.projectService.save(currentProject);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/home/delete/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable("id") Integer id) {
        Project project = this.projectService.findById(id);
        if (project == null) {
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
        this.projectService.deleteById(id);
        return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/home/searchStudent")
    public ResponseEntity<List<Project>> searchByStudent(@RequestParam String nameStudent,
                                                         @RequestParam String nameTeacher) {
        List<Project> projectList = this.projectService.searchByStudent(nameStudent, nameTeacher);
        if (projectList.isEmpty()) {
            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
    }

//    @GetMapping("/home/searchTeacher")
//    public ResponseEntity<List<Project>> searchByTeacher(@RequestParam String nameTeacher) {
//        List<Project> projectList = this.projectService.searchByTeacher(nameTeacher);
//        if (projectList.isEmpty()) {
//            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
//    }
}

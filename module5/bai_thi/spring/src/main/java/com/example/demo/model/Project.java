package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameStudent;
    private String nameGroup;
    private String nameProject;
    private String nameTeacher;
    private String email;
    private String phone;

    public Project(Integer id, String nameStudent, String nameGroup, String nameProject, String nameTeacher, String email, String phone) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.nameGroup = nameGroup;
        this.nameProject = nameProject;
        this.nameTeacher = nameTeacher;
        this.email = email;
        this.phone = phone;
    }

    public Project(String nameStudent, String nameGroup, String nameProject, String nameTeacher, String email, String phone) {
        this.nameStudent = nameStudent;
        this.nameGroup = nameGroup;
        this.nameProject = nameProject;
        this.nameTeacher = nameTeacher;
        this.email = email;
        this.phone = phone;
    }

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

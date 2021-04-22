package com.example.casestudy.model.employee;

import javax.persistence.*;

@Entity(name = "users")
@Table
public class User {

    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "passwords", nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Employee employee) {
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

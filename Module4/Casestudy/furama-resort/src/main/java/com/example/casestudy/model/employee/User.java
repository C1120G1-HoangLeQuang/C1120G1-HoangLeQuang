package com.example.casestudy.model.employee;

import javax.persistence.*;

@Entity(name = "users")
@Table(uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "username")})
public class User {

    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "passwords", nullable = false)
    private String password;
    @Column(name = "enabled", nullable = false, columnDefinition = "bit default 1")
    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, boolean enabled, Employee employee) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

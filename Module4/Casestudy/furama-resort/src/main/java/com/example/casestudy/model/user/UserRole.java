package com.example.casestudy.model.user;

import com.example.casestudy.model.employee.User;

import javax.persistence.*;

@Entity(name = "user_role")
@Table(uniqueConstraints = {@UniqueConstraint(name = "USER_ROLE_UK", columnNames = {"username", "role_id"})})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;

    public UserRole() {
    }

    public UserRole(User user, AppRole appRole) {
        this.user = user;
        this.appRole = appRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}

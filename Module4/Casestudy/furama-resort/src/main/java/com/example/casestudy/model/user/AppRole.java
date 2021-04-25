package com.example.casestudy.model.user;

import javax.persistence.*;

@Entity(name = "roles")
@Table(uniqueConstraints = {@UniqueConstraint(name = "APP_ROLE_UL", columnNames = "role_name")})
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer roleId;
    @Column(name = "role_name", nullable = false)
    private String roleName;

    public AppRole() {
    }

    public AppRole(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

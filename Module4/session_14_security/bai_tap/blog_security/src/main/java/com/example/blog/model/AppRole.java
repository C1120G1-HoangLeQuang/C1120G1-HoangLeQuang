package com.example.blog.model;

import javax.persistence.*;

@Entity(name = "App_Role")
@Table(uniqueConstraints = { @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name")})
public class AppRole {

    @Id
    @GeneratedValue
    @Column(name = "Role_Id", nullable = false)
    private Long roleId;

    @Column(name = "Role_Name", length = 120, nullable = false)
    private String roleName;

    public AppRole() {
    }

    public AppRole(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

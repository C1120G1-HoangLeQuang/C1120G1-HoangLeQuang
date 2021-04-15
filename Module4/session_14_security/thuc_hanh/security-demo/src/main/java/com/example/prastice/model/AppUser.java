package com.example.prastice.model;

import javax.persistence.*;

@Entity(name = "App_User")
@Table(uniqueConstraints = { @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name")})
public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @Column(name = "User_Name", length = 120, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 120, nullable = false)
    private String encrytedPassword;

    @Column(name = "Enable", length = 1, nullable = false)
    private boolean enable;

    public AppUser() {
    }

    public AppUser(Long userId, String userName, String encrytedPassword, boolean enable) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.enable = enable;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}

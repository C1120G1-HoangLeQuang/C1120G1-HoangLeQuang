package com.example.casestudy.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/login")
    public String getLogin() {
        return "loginPage";
    }

    @GetMapping("/giamdoc")
    public String giamdocPage() {
        return "homePage";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "homePage";
    }

    @GetMapping("/nhanvien")
    public String nhanvienPage() {
        return "homePage";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "login/403Page";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}

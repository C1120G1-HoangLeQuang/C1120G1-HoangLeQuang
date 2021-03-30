package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String user, @RequestParam String password, Model model){
        if ("admin".equals(user) && "123456".equals(password)){
            model.addAttribute("username", user);
            return "result";
        }else {
            return "index";
        }

    }
}

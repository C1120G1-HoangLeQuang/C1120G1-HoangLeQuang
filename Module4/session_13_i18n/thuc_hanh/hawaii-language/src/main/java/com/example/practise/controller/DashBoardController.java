package com.example.practise.controller;

import com.example.practise.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DashBoardController {


    @GetMapping("/dashboard")
    public String login() {
        return "result";
    }

}

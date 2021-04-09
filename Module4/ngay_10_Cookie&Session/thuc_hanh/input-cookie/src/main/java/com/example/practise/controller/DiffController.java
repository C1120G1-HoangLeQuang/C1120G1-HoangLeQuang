package com.example.practise.controller;

import com.example.practise.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiffController {


    @GetMapping("/goHome")
    public String goHome(@SessionAttribute("user") User user, Model model) {
        model.addAttribute("userInSession", user);
        return "home";
    }
}

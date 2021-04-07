package com.example.exercise.controller;

import com.example.exercise.model.User;
import com.example.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ModelAndView getListUser() {
        return new ModelAndView("user/list", "userList", this.userService.findAll());
    }

    @GetMapping("user/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("user/create", "userList", new User());
    }

    @PostMapping("/user/save")
    public ModelAndView creatNewUser(@Validated @ModelAttribute("userList") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("user/create");
            return modelAndView;
        }
        this.userService.save(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/user");
        return modelAndView;
    }
}

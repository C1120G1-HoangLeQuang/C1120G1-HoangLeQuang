package com.example.practise.controller;

import com.example.practise.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
//Annotation @SessionAttributes("user") được sử dụng để lưu trữ thông tin của model attribute có tên là user.
@SessionAttributes("user")
public class LoginController {

//    Annotation @ModelAttribute("user") sẽ nhận user trả về từ view, sau đó đưa vào session:

    @ModelAttribute("user")
    public User setUpLoginForm() {
        return new User();
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        return new ModelAndView("login", "cookieValue", setUser);
    }

    @PostMapping("/dologin")
    public String login(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                        HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("hoanglequang@gmail.com") && user.getPassword().equals("12345")) {
            setUser = user.getEmail();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            model.addAttribute("message", "Login success. Welcome ");
            return "redirect:/goHome";
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie.getValue());
            model.addAttribute("message", "Login failed. Try again.");
            return "login";
        }
    }
}

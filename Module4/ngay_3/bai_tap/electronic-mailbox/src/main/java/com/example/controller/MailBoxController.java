package com.example.controller;

import com.example.Repository.MailBoxRepository;
import com.example.Service.MailBoxService;
import com.example.model.MailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    MailBoxService mailBoxService;

    @GetMapping("/")
    public ModelAndView showCreate(Model model) {
        List<String> listLanguage = this.mailBoxService.getListLanguage();
        model.addAttribute("listLanguage", listLanguage);
        List<Integer> listPageSize = this.mailBoxService.getListPageSize();
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("create", "mailBox", new MailBox());
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MailBox mailBox) {
        return new ModelAndView("information", "mailBox", mailBox);
    }

}

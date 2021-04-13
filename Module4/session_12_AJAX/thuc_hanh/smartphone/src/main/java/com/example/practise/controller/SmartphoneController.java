package com.example.practise.controller;

import com.example.practise.model.Smartphone;
import com.example.practise.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SmartphoneController {

    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("/smartphone")
    public ModelAndView showIndex(){
        return new ModelAndView("/index", "smartphoneList", this.smartphoneService.findAll());
    }

    @GetMapping("/smartphone/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/smartphone/create", "phone", new Smartphone());
    }

    @PostMapping("/smartphone/save")
    public String createSmartphone(@ModelAttribute Smartphone smartphone) {
        this.smartphoneService.save(smartphone);
        return "redirect:/smartphone";
    }

    @GetMapping("/smartphone/edit/{id}")
    public ModelAndView showEditPage(@PathVariable("id") Integer id) {
        return new ModelAndView("/smartphone/edit", "phone", this.smartphoneService.findById(id));
    }

    @PostMapping("/smartphone/update")
    public String updateSmartphone(@ModelAttribute Smartphone smartphone) {
        this.smartphoneService.save(smartphone);
        return "redirect:/smartphone";
    }

    @GetMapping("/smartphone/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable("id") Integer id) {
        return new ModelAndView("/smartphone/delete", "phone", this.smartphoneService.findById(id));
    }

    @PostMapping("/smartphone/delete")
    public String deleteSmartphone(Integer id) {
        this.smartphoneService.deleteById(id);
        return "redirect:/smartphone";
    }

}

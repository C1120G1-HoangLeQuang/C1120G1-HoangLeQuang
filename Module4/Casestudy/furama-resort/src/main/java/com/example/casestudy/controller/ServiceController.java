package com.example.casestudy.controller;

import com.example.casestudy.model.service.Service;
import com.example.casestudy.service.services.RentTypeService;
import com.example.casestudy.service.services.ServiceServices;
import com.example.casestudy.service.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ServiceController {

    @Autowired
    ServiceServices serviceServices;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping("/service")
    public ModelAndView getServiceList(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Service> serviceList = this.serviceServices.findAll(pageable1);
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("serviceList", serviceList);
        return modelAndView;
    }

    @GetMapping("/service/createVilla")
    public ModelAndView getCreateFormVilla() {
        ModelAndView modelAndView = new ModelAndView("service/createVilla");
        modelAndView.addObject("rentTypeList", this.rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList", this.serviceTypeService.findAll());
        modelAndView.addObject("services", new Service());
        return modelAndView;
    }

    @GetMapping("/service/createHouse")
    public ModelAndView getCreateFormHouse() {
        ModelAndView modelAndView = new ModelAndView("service/createHouse");
        modelAndView.addObject("rentTypeList", this.rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList", this.serviceTypeService.findAll());
        modelAndView.addObject("services", new Service());
        return modelAndView;
    }

    @GetMapping("/service/createRoom")
    public ModelAndView getCreateFormRoom() {
        ModelAndView modelAndView = new ModelAndView("service/createRoom");
        modelAndView.addObject("rentTypeList", this.rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList", this.serviceTypeService.findAll());
        modelAndView.addObject("services", new Service());
        return modelAndView;
    }

    @PostMapping("/service/saveVilla")
    private ModelAndView createNewVilla(@Validated @ModelAttribute(name = "services") Service service,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("service/createVilla");
            modelAndView.addObject("rentTypeList", this.rentTypeService.findAll());
            modelAndView.addObject("serviceTypeList", this.serviceTypeService.findAll());
            return modelAndView;
        }
        this.serviceServices.save(service);
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        redirect.addFlashAttribute("message", "Service " + service.getSerId() + " was created");
        return modelAndView;
    }

    @PostMapping("/service/saveHouse")
    private ModelAndView createNewHouse(@Validated @ModelAttribute(name = "services") Service service,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("service/createHouse");
            modelAndView.addObject("rentTypeList", this.rentTypeService.findAll());
            modelAndView.addObject("serviceTypeList", this.serviceTypeService.findAll());
            return modelAndView;
        }
        this.serviceServices.save(service);
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        redirect.addFlashAttribute("message", "Service " + service.getSerId() + " was created");
        return modelAndView;
    }

    @PostMapping("/service/saveRoom")
    private ModelAndView createNewRoom(@Validated @ModelAttribute(name = "services") Service service,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("service/createRoom");
            modelAndView.addObject("rentTypeList", this.rentTypeService.findAll());
            modelAndView.addObject("serviceTypeList", this.serviceTypeService.findAll());
            return modelAndView;
        }
        this.serviceServices.save(service);
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        redirect.addFlashAttribute("message", "Service " + service.getSerId() + " was created");
        return modelAndView;
    }
}

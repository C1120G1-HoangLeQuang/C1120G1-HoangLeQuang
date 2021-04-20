package com.example.casestudy.controller;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.service.customer.CustomerService;
import com.example.casestudy.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping("/customer")
    public ModelAndView getListCustomer(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Customer> customerList = this.customerService.findAll(pageable1);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("cusTypeList", this.customerTypeService.findAll());
        modelAndView.addObject("customers", new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public String createNewCustomer(Customer customer, RedirectAttributes redirect) {
        this.customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer " + customer.getCusId() + " was created");
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit")
    public ModelAndView getEditForm(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("cusTypeList", this.customerTypeService.findAll());
        modelAndView.addObject("customers",this.customerService.findByCusId(id));
        return modelAndView;
    }

    @PostMapping("/customer/edit")
    public String updateCustomer(Customer customer, RedirectAttributes redirect) {
        this.customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer " + customer.getCusId() + " was updated");
        return "redirect:/customer";
    }

    @GetMapping("/customer/delete")
    public ModelAndView getDeleteForm(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customers",this.customerService.findByCusId(id));
        return modelAndView;
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(@RequestParam String id, RedirectAttributes redirect) {
        this.customerService.deleteById(id);
        redirect.addFlashAttribute("message", "Customer " + id + " was deleted");
        return "redirect:/customer";
    }

    @GetMapping("/customer/search")
    public ModelAndView searchByName(@RequestParam("cusName") Optional<String> cusName, Pageable pageable) {
        Page<Customer> customerList;
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 2);
        if (cusName.isPresent()) {
           customerList = this.customerService.findAllByCusNameContaining(cusName.get(), pageable1);
        } else {
            customerList = this.customerService.findAll(pageable1);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}

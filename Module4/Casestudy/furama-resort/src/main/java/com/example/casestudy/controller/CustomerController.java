package com.example.casestudy.controller;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.service.customer.CustomerService;
import com.example.casestudy.service.customer.CustomerTypeService;
import com.example.casestudy.service.customer.impl.CustomerServiceImpl;
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

    @GetMapping("/furama")
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

    @PostMapping("/customer/save")
    public ModelAndView createNewCustomer(@Validated @ModelAttribute(name = "customers") Customer customer,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirect) {
        this.customerService.validateCustomerIdExist(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addObject("cusTypeList", this.customerTypeService.findAll());
            return modelAndView;
        }
        this.customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        redirect.addFlashAttribute("message", "Customer " + customer.getCusId() + " was created");
        return modelAndView;
    }

    @GetMapping("/customer/edit")
    public ModelAndView getEditForm(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("cusTypeList", this.customerTypeService.findAll());
        modelAndView.addObject("customers",this.customerService.findByCusId(id));
        return modelAndView;
    }

    @PostMapping("/customer/update")
    public ModelAndView updateCustomer(@Validated @ModelAttribute(name = "customers") Customer customers,
                                       BindingResult bindingResult,
                                 RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customers", customers); // tra ve doi tuong de nhan thong tin
            modelAndView.addObject("cusTypeList", this.customerTypeService.findAll());
            return modelAndView;
        }
        this.customerService.save(customers);
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        redirect.addFlashAttribute("message", "Customer " + customers.getCusId() + " was updated");
        return modelAndView;
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

package com.example.casestudy.controller;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.model.employee.User;
import com.example.casestudy.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    UserService userService;

    @GetMapping("/employee")
    public ModelAndView getEmployeeList(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Employee> employeeList = this.employeeService.findAll(pageable1);
        ModelAndView modelAndView = new ModelAndView("employee/listEmployee");
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
    }

    @GetMapping("/employee/search")
    public ModelAndView searchByName(Pageable pageable, @RequestParam("emName") Optional<String> employeeName) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Employee> employeeList;
        if (employeeName.isPresent()) {
            employeeList = this.employeeService.findByEmNameContaining(employeeName.get(), pageable1);
        } else {
            employeeList = this.employeeService.findAll(pageable1);
        }
        ModelAndView modelAndView = new ModelAndView("employee/listEmployee");
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
    }

    @GetMapping("/employee/create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/createEmployee");
        modelAndView.addObject("positionList", this.positionService.findAll());
        modelAndView.addObject("educationDegreeList", this.educationDegreeService.findAll());
        modelAndView.addObject("divisionList", this.divisionService.findAll());
        modelAndView.addObject("employees", new Employee());
        return modelAndView;
    }

    @PostMapping("/employee/save")
    public String createNewEmployee(@Validated @ModelAttribute(name = "employees") Employee employee,
                                    BindingResult bindingResult,
                                    @RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    Model model,
                                    RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positionList", this.positionService.findAll());
            model.addAttribute("educationDegreeList", this.educationDegreeService.findAll());
            model.addAttribute("divisionList", this.divisionService.findAll());
            return "employee/createEmployee";
        }
        User user = this.userService.createNewUser(username, password);
        model.addAttribute("user",user);
        employee.setUser(user);
        this.employeeService.save(employee);
        redirect.addFlashAttribute("message", "Employee " + employee.getEmId() + " was created");
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit")
    public ModelAndView getEditForm(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("employee/editEmployee");
        modelAndView.addObject("positionList", this.positionService.findAll());
        modelAndView.addObject("educationDegreeList", this.educationDegreeService.findAll());
        modelAndView.addObject("divisionList", this.divisionService.findAll());
        modelAndView.addObject("employees", this.employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/employee/update")
    public ModelAndView updateEmployee(@Validated @ModelAttribute(name = "employees")Employee employee,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/editEmployee");
            modelAndView.addObject("employees", employee);
            modelAndView.addObject("positionList", this.positionService.findAll());
            modelAndView.addObject("educationDegreeList", this.educationDegreeService.findAll());
            modelAndView.addObject("divisionList", this.divisionService.findAll());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        this.employeeService.save(employee);
        redirect.addFlashAttribute("message", "Employee " + employee.getEmId() + " was updated");
        return modelAndView;
    }

    @GetMapping("/employee/delete")
    public ModelAndView getDeleteForm(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("/employee/deleteEmployee");
        modelAndView.addObject("employees", this.employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/employee/delete")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirect) {
        this.employeeService.deleteById(id);
        redirect.addFlashAttribute("message", "Employee " + id + " was deleted");
        return "redirect:/employee";
    }
}

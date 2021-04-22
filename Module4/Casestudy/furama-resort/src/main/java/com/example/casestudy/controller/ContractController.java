package com.example.casestudy.controller;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.service.contract.AttachServiceService;
import com.example.casestudy.service.contract.ContractDetailService;
import com.example.casestudy.service.contract.ContractService;
import com.example.casestudy.service.customer.CustomerService;
import com.example.casestudy.service.employee.EmployeeService;
import com.example.casestudy.service.services.ServiceServices;
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

import java.util.List;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    AttachServiceService attachServiceService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceServices serviceServices;


    @GetMapping("/contract")
    public ModelAndView getContractList(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Contract> contractList = this.contractService.findAll(pageable1);
        ModelAndView modelAndView = new ModelAndView("contract/listContract");
        modelAndView.addObject("contractList", contractList);
        return modelAndView;
    }

    @GetMapping("/contract/create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract/createContract");
        modelAndView.addObject("employeeList", this.employeeService.findAll());
        modelAndView.addObject("customerList", this.customerService.findAll());
        modelAndView.addObject("serviceList", this.serviceServices.findAll());
        modelAndView.addObject("contracts", new Contract());
        return modelAndView;
    }

    @PostMapping("/contract/save")
    public String createNewContract(Contract contract, RedirectAttributes redirect) {
        this.contractService.save(contract);
        redirect.addFlashAttribute("message", "Contract " + contract.getConId() + " is created");
        return "redirect:/contract";
    }

    @GetMapping("/contract-detail/view")
    public ModelAndView getConDetailList(@RequestParam(name = "idContract") Integer idContract) {
        ModelAndView modelAndView = new ModelAndView("contract/listContractDetail");
        Contract contract = this.contractService.findById(idContract);
        modelAndView.addObject(contract);
        modelAndView.addObject("contractDetails",  this.contractDetailService.findAllByContract(contract));
        return modelAndView;
    }

    @GetMapping("/contract-detail/create")
    public ModelAndView getCreateForm(@RequestParam Integer idContract) {
        ModelAndView modelAndView = new ModelAndView("contract/createContractDetail");
        Contract contract = this.contractService.findById(idContract);
        modelAndView.addObject(contract);
        modelAndView.addObject("attachServiceList", this.attachServiceService.findAll());
        modelAndView.addObject("contractDetails", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/contract-detail/save")
    public String createNewConDetail(@RequestParam Integer idContract, ContractDetail contractDetail,RedirectAttributes redirect) {
        Contract contract = this.contractService.findById(idContract);
        contractDetail.setContract(contract);
        this.contractDetailService.save(contractDetail);
        redirect.addFlashAttribute("message", "Contract detail in contract id: " + contract.getConId() + " is created");
        return "redirect:/contract";
    }
}

package com.example.casestudy.controller;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.service.contract.AttachServiceService;
import com.example.casestudy.service.contract.ContractDetailService;
import com.example.casestudy.service.contract.ContractService;
import com.example.casestudy.service.contract.impl.ContractServiceImpl;
import com.example.casestudy.service.customer.CustomerService;
import com.example.casestudy.service.employee.EmployeeService;
import com.example.casestudy.service.services.ServiceServices;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ModelAndView createNewContract(@Validated @ModelAttribute(name = "contracts") Contract contract,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirect) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("contract/createContract");
            modelAndView.addObject("employeeList", this.employeeService.findAll());
            modelAndView.addObject("customerList", this.customerService.findAll());
            modelAndView.addObject("serviceList", this.serviceServices.findAll());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        this.contractService.save(contract);
        redirect.addFlashAttribute("message", "Contract " + contract.getConId() + " is created");
        return modelAndView;
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
    public ModelAndView createNewConDetail(@RequestParam Integer idContract,
                                           @ModelAttribute(name = "contractDetails") ContractDetail contractDetail,
                                           BindingResult bindingResult,
                                           RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("contract/createContractDetail");
            Contract contract = this.contractService.findById(idContract);
            modelAndView.addObject(contract);
            modelAndView.addObject("attachServiceList", this.attachServiceService.findAll());
            return modelAndView;
        }
        Contract contract = this.contractService.findById(idContract);
        contractDetail.setContract(contract);
        this.contractDetailService.save(contractDetail); // add new Contract detail
        this.contractService.save(contract); // update lai contract : totalMoney
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        redirect.addFlashAttribute("message", "Contract detail in contract id: " + contract.getConId() + " is created");
        return modelAndView;
    }

    @GetMapping("/contract/customerEXP")
    public ModelAndView getCustomerListEXP(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3);
        String inputDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Page<Contract> contractList = this.contractService.getCustomerByEndDate(inputDate, pageable1);
        ModelAndView modelAndView = new ModelAndView("contract/listCustomerEXP");
        modelAndView.addObject("contractList", contractList);
        return modelAndView;
    }

    @GetMapping("/contract/customerEXP/search")
    public ModelAndView searchCustomerListEXP(@RequestParam("cusName") Optional<String> cusName, Pageable pageable) {
        Page<Contract> contractList;
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 2);
        String inputDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (cusName.isPresent()) {
            contractList = this.contractService.getListContractByName("%"+cusName.get()+"%", inputDate, pageable);
        } else {
            contractList = this.contractService.getCustomerByEndDate(inputDate, pageable1);
        }
        ModelAndView modelAndView = new ModelAndView("contract/listCustomerEXP");
        modelAndView.addObject("contractList", contractList);
        return modelAndView;
    }

    @GetMapping("/contract/customerEXP/delete")
    public ModelAndView getDeleteForm(@RequestParam Integer idContract) {
        ModelAndView modelAndView = new ModelAndView("contract/deleteContract");
        modelAndView.addObject("contracts", this.contractService.findById(idContract));
        return modelAndView;
    }

    @PostMapping("/contract/customerEXP/delete")
    public String deleteContract(@RequestParam Integer idContract, Model model, RedirectAttributes redirect) {
        this.contractService.deleteById(idContract);
        redirect.addFlashAttribute("message", "Contract " + idContract + " was deleted");
        return "redirect:/contract/customerEXP";
    }
}

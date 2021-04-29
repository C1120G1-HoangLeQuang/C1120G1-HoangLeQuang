package com.example.test.controller;

import com.example.test.model.ProductBill;
import com.example.test.service.ProductBillService;
import com.example.test.service.ProductService;
import com.example.test.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductBillController {

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductBillService productBillService;

    @GetMapping("/product-bill")
    public ModelAndView getBillList(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 5);
        Page<ProductBill> productBillList = this.productBillService.findAll(pageable1);
        ModelAndView modelAndView = new ModelAndView("folder1/list");
        modelAndView.addObject("productBillList", productBillList);
        return modelAndView;
    }

    @GetMapping("/product-bill/edit")
    public ModelAndView getEditForm(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("folder1/edit");
        modelAndView.addObject("productTypeList", this.productTypeService.findAll());
        modelAndView.addObject("productList", this.productService.findAll());
        modelAndView.addObject("productBills",this.productBillService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product-bill/update")
    public ModelAndView updateProductBill(@ModelAttribute(name = "productBills") ProductBill productBill,
                                          RedirectAttributes redirect) {
        this.productBillService.save(productBill);
        ModelAndView modelAndView = new ModelAndView("redirect:/product-bill");
        redirect.addFlashAttribute("message", "Bill " + productBill.getProductBillId() + " was updated");
        return modelAndView;
    }

    @PostMapping("/product-bill/search")
    public ModelAndView searchBillByDate(@RequestParam(name = "fromDate1") String fromDate, @RequestParam(name = "toDate1") String toDate,
                                         Pageable pageable) {
        Page<ProductBill> productBillList;
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 5);
        productBillList = this.productBillService.findAllByBuyDate(fromDate, toDate, pageable1);
        ModelAndView modelAndView = new ModelAndView("folder1/listSearch");
        modelAndView.addObject("productBillList", productBillList);
        return modelAndView;
    }

    @PostMapping("/product-bill/top")
    public ModelAndView getTop(@RequestParam(name = "top") Integer top) {
        List<ProductBill> productBillList;
        productBillList = this.productBillService.findAllByTop(top);
        ModelAndView modelAndView = new ModelAndView("folder1/listTop");
        modelAndView.addObject("productBillList", productBillList);
        return modelAndView;
    }
}

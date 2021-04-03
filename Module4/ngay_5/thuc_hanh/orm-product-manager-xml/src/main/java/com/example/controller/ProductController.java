package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView index() {
        List<Product> listProduct = this.productService.findAll();
        return new ModelAndView("/index", "products", listProduct);
    }

    @GetMapping("/product/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create", "products", new Product());
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product) {
        product.setId((int)(Math.random() * 10000));
        this.productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        return new ModelAndView("/edit", "products", this.productService.findById(id));
    }

    @PostMapping("/product/update")
    public String updateProduct(Product product) {
        this.productService.save(product);
        return "redirect:/";
    }


    @PostMapping("/product/delete")
    public String deleteForm(@RequestParam Integer id, RedirectAttributes redirect) {
        redirect.addFlashAttribute("message", "Delete product successfully");
        productService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView viewProduct(@PathVariable Integer id) {
        return new ModelAndView("/view", "products", this.productService.findById(id));
    }
}

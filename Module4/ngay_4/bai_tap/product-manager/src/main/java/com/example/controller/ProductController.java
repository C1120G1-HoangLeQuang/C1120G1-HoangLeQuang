package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return new ModelAndView("/index", "productMap", listProduct);
    }

    @GetMapping("/product/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create", "productMap", new Product());
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product) {
        product.setId((int)(Math.random() * 10000));
        this.productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView showEditForm(@PathVariable int id) {
        return new ModelAndView("/edit", "productMap", this.productService.findById(id));
    }

    @PostMapping("/product/update")
    public String updateProduct(Product product) {
        this.productService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        return new ModelAndView("/delete", "productMap", this.productService.findById(id));
    }

    @PostMapping("/product/delete")
    public String deleteForm(Product product) {
        this.productService.remove(product.getId());
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView viewProduct(@PathVariable int id) {
        return new ModelAndView("/view", "productMap", this.productService.findById(id));
    }
}

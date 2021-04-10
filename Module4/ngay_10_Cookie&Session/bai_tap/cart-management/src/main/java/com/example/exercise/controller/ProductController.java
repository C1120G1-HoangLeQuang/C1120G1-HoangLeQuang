package com.example.exercise.controller;

import com.example.exercise.model.Cart;
import com.example.exercise.model.CartManager;
import com.example.exercise.model.Product;
import com.example.exercise.service.ProductService;
import com.example.exercise.service.impl.CartService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;

    @GetMapping("/cart")
    public ModelAndView getCartList() {
        return new ModelAndView("product/listCart");
    }

    @GetMapping("/product")
    public ModelAndView getProductList(){
        return new ModelAndView("product/listProduct", "productList", productService.findAll());
    }

    @GetMapping("/product/create")
    public ModelAndView getCreateForm() {
        return new ModelAndView("product/createProduct", "products", new Product());
    }

    @PostMapping("/product/save")
    public String createNewProduct(Product product) {
        this.productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/view/{id}")
    public ModelAndView getViewForm(@PathVariable("id") Integer id) {
        return new ModelAndView("product/viewProduct", "products", this.productService.findById(id));
    }

    @PostMapping("/cart/add")
    public String addToCart(HttpSession session, @RequestParam(value = "id", required = false) Integer id,
                            @RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity) {
        Product product = this.productService.findById(id);

        CartManager cartManager = this.cartService.getCartManager(session);
        cartManager.addProductToCart(product, quantity);
        return "product/listCart";
    }

    @PostMapping("/cart/remove")
    public String remove(HttpSession session, @RequestParam("id") Integer id) {
        Product product = this.productService.findById(id);
        CartManager cartManager = this.cartService.getCartManager(session);
        cartManager.deleteProduct(product);
        return "product/listCart";
    }

    @PostMapping("/cart/clear")
    public String remove(HttpSession session) {
        CartManager cartManager = this.cartService.getCartManager(session);
        cartManager.clearAll();
        return "product/listCart";
    }

    @PostMapping("/cart/editCart")
    public String update(HttpSession session, @RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
        Product product = this.productService.findById(id);
        CartManager cartManager = this.cartService.getCartManager(session);
        cartManager.updateProduct(product, quantity);
        return "product/listCart";
    }
}

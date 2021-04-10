package com.example.exercise.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Product product;
    private Integer amount;

    public Cart() {
    }

    public Cart(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

package com.example.exercise.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cart {
    Map<Product, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addToCart(Product product) {
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product), cart.get(product) +1);
        } else {
            cart.put(product, 1);
        }
    }

    public int getAmount(Product product) {
        return cart.get(product);
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }

    public void clearAllProduct() {
        cart.clear();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }


}

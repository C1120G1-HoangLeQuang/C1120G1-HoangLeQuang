package com.example.exercise.model;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private List<Cart> cartList;
    public CartManager() {
        cartList = new ArrayList<Cart>();
    }

    //lay 1 product trong gio hang
    public Cart getProductInCart(Product product) {
        for (Cart item : cartList) {
            if (item.getProduct().getIdProduct() == product.getIdProduct()) { //da ton tai product trong gio hang
                return item;
            }
        }
        return null; // khong ton tai product trong gio hang
    }

    //Lay tat ca product trong gio hang
    public List<Cart> getAllProductInCart() {
        return cartList;
    }

    //lay so luong product co trong list
    public int getProductCount() {
        return cartList.size();
    }

    //them product vao cart
    public void addProductToCart(Product product, Integer quantity) {
        Cart item = getProductInCart(product);
        if (item != null) {
            item.setAmount(item.getAmount() +1);
        } else {
            item = new Cart();
            item.setAmount(quantity);
            cartList.add(item);
        }
    }

    //update product trong cart
    public void updateProduct(Product product, Integer quantity) {
        Cart item  = getProductInCart(product); // lay product trong gio ra de update
        if (item != null) {
            item.setAmount(quantity);
        }

    }

    // xoa product trong gio hang
    public void deleteProduct(Product product) {
        Cart item = getProductInCart(product);
        if (item != null) {
            cartList.remove(item);
        }
    }

    //xoa toan bo gio hang
    public void clearAll() {
        cartList.clear();
    }

}

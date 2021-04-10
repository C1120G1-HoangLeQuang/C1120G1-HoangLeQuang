package com.example.exercise.service.impl;

import com.example.exercise.model.CartManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CartService {
    private static final String SESSION_CART = "cartSession";

    //lay ve gio hang duoc luu trong Session
    public CartManager getCartManager(HttpSession session) {
        CartManager cartManager = (CartManager)session.getAttribute(SESSION_CART);
        if (cartManager == null) {
            cartManager = new CartManager();
            setCartManager(session, cartManager);
        }
        return cartManager;
    }

    //thiet lap mot gio hang duoc luu trong Session
    public void setCartManager(HttpSession session, CartManager cartManager) {
        session.setAttribute(SESSION_CART, cartManager);
    }
}

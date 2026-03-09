package com.swiftbites.api.controller;

import com.swiftbites.api.entity.CartEntity;
import com.swiftbites.api.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public CartEntity addToCart(@RequestBody CartEntity cart) {
        return cartService.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<CartEntity> getCartItems(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}
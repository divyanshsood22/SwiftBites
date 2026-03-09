package com.swiftbites.api.service;

import com.swiftbites.api.entity.CartEntity;
import java.util.List;

public interface CartService {

    CartEntity addToCart(CartEntity cart);

    List<CartEntity> getCartItems(Long userId);

    void clearCart(Long userId);
}
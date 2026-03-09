package com.swiftbites.api.service;

import com.swiftbites.api.entity.CartEntity;
import com.swiftbites.api.repository.CartRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRespository cartRepository;

    @Override
    public CartEntity addToCart(CartEntity cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<CartEntity> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void clearCart(Long userId) {
        cartRepository.deleteByUserId(userId);
    }
}
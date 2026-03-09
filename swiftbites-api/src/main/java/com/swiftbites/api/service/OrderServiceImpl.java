package com.swiftbites.api.service;

import com.swiftbites.api.entity.CartEntity;
import com.swiftbites.api.entity.OrderEntity;
import com.swiftbites.api.repository.OrderRepository;
import com.swiftbites.api.repository.CartRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRespository cartRepository;

    @Override
    public OrderEntity placeOrder(OrderEntity order) {
        List<CartEntity> cartItems = cartRepository.findByUserId(order.getUserId());
        for (CartEntity item : cartItems) {
            item.setOrder(order);
        }
        order.setOrderedItems(cartItems);
        OrderEntity savedOrder = orderRepository.save(order);
        cartRepository.deleteByUserId(order.getUserId());
        return savedOrder;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
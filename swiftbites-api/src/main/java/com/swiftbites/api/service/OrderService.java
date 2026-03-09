package com.swiftbites.api.service;

import com.swiftbites.api.entity.OrderEntity;
import java.util.List;

public interface OrderService {

    OrderEntity placeOrder(OrderEntity order);

    List<OrderEntity> getAllOrders();

    void deleteOrder(Long id);
}
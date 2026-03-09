package com.swiftbites.api.controller;

import com.swiftbites.api.entity.OrderEntity;
import com.swiftbites.api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<OrderEntity> getOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
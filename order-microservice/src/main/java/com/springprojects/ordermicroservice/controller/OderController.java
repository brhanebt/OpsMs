package com.springprojects.ordermicroservice.controller;

import com.springprojects.ordermicroservice.model.Order;
import com.springprojects.ordermicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getOrdersFromCsv() {
        return orderService.getOrdersFromCsv();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrdersFromCsv().stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}

package com.springprojects.ordermicroservice.controller;

import com.springprojects.ordermicroservice.model.Order;
import com.springprojects.ordermicroservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Order", description = "Order API")
public class OderController {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieve a list of all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Order> getOrders() {
        return orderService.getOrdersFromCsv();
    }
    public List<Order> getOrdersFromCsv() {
        return orderService.getOrdersFromCsv();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID", description = "Retrieve a specific order by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved order"),
            @ApiResponse(responseCode = "404", description = "Order not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrdersFromCsv().stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}

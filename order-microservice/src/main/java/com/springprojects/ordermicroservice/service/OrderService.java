package com.springprojects.ordermicroservice.service;

import com.springprojects.ordermicroservice.model.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public List<Order> getOrdersFromCsv() {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ClassPathResource("data/orders.csv").getInputStream()))) {
            
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Order order = new Order();
                order.setId(Long.parseLong(fields[0]));
                order.setProduct(fields[1]);
                order.setQuantity(Integer.parseInt(fields[2]));
                order.setPrice(Double.parseDouble(fields[3]));
                order.setStatus(fields[4]);
                orders.add(order);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading orders from CSV", e);
        }
        return orders;
    }
}

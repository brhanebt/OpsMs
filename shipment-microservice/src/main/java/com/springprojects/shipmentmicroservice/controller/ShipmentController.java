package com.springprojects.shipmentmicroservice.controller;

import com.springprojects.shipmentmicroservice.model.Shipment;
import com.springprojects.shipmentmicroservice.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    @GetMapping
    public Flux<Shipment> getShipments() {
        return shipmentService.getAllShipments().onBackpressureBuffer(3);
    }


}

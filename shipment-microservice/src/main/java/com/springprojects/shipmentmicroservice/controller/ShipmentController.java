package com.springprojects.shipmentmicroservice.controller;

import com.springprojects.shipmentmicroservice.model.Shipment;
import com.springprojects.shipmentmicroservice.service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shipments")
@Tag(name = "Shipment", description = "Shipment API")
public class ShipmentController {
    private final ShipmentService shipmentService;

    @GetMapping
    @Operation(summary = "Get all shipments", description = "Retrieve a list of all shipments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Flux<Shipment> getShipments() {
        return shipmentService.getAllShipments().onBackpressureBuffer(3);
    }


}

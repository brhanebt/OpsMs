package com.springprojects.shipmentmicroservice.model;

import lombok.Data;

@Data
public class Shipment {
    private Long id;
    private String orderId;
    private String shipmentDate;
    private ShipmentStatus status;
}

package com.springprojects.shipmentmicroservice.service;

import com.springprojects.shipmentmicroservice.model.Shipment;
import com.springprojects.shipmentmicroservice.model.ShipmentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@Slf4j
public class ShipmentService {

    public Flux<Shipment> getAllShipments(){
        return Flux.defer(() -> {
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new ClassPathResource("data/shipments.txt").getInputStream())
                );
                return Flux.fromStream(reader.lines())
                    .skip(1) // Skip header
                    .map(line -> {
                        String[] fields = line.split(",");
                        Shipment shipment = new Shipment();
                        shipment.setId(Long.parseLong(fields[0].replace("SHIP", "")));
                        shipment.setOrderId(fields[0]);
                        shipment.setShipmentDate(fields[1]);
                        shipment.setStatus(ShipmentStatus.valueOf(fields[4]));
                        return shipment;
                    });
            } catch (Exception e) {
                log.error(e.getMessage());
                return Flux.empty();
            }
        });
    }



}
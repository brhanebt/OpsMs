package com.springprojects.paymentmicroservice.model;

import lombok.Data;

@Data
public class Payment {
    private Long id;
    private String orderId;
    private Double amount;
    private PaymentStatus status;
}

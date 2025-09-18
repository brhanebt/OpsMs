package com.springprojects.paymentmicroservice.controller;

import com.springprojects.paymentmicroservice.model.Payment;
import com.springprojects.paymentmicroservice.service.PaymentServce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentServce paymentService;

    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }


}

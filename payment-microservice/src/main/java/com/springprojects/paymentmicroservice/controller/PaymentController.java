package com.springprojects.paymentmicroservice.controller;

import com.springprojects.paymentmicroservice.model.Payment;
import com.springprojects.paymentmicroservice.service.PaymentServce;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Tag(name = "Payment", description = "Payment API")
public class PaymentController {

    private PaymentServce paymentService;

    @GetMapping
    @Operation(summary = "Get all payments", description = "Retrieve a list of all payments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }


}

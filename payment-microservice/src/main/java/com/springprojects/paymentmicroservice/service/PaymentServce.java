package com.springprojects.paymentmicroservice.service;

import com.springprojects.paymentmicroservice.model.Payment;
import com.springprojects.paymentmicroservice.model.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PaymentServce {

    public List<Payment> getAllPayments(){
        List<Payment> payments = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(new ClassPathResource("data/payments.txt").getInputStream())
        )){
            String line;
            in.readLine(); // skip header
            while((line=in.readLine()) != null){
                String[] fields = line.split(",");
                Payment payment = new Payment();
                payment.setId(Long.parseLong(fields[0]));
                payment.setOrderId(fields[1]);
                payment.setAmount(Double.parseDouble(fields[2]));
                payment.setStatus(PaymentStatus.valueOf(fields[3]));
                payments.add(payment);
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return payments;
    }
}

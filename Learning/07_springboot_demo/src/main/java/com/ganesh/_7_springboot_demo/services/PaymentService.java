package com.ganesh._7_springboot_demo.services;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public PaymentService() {
        System.out.println("Payment Service Constructor Called");
    }

    public void pay() {
        System.out.println("Payment processed successfully!");
    }
}

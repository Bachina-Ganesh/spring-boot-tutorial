package com.ganesh.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service Initialized");
        System.out.println(paymentService);
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        paymentService.pay();

    }
}

package com.ganesh.services;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service Initialized");
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        paymentService.pay();
    }

    public void getOrderDetails() {
        System.out.println("Fetching order details...");
    }
}

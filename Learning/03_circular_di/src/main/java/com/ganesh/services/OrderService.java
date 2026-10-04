package com.ganesh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private PaymentService paymentService;

//    public OrderService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//        System.out.println("Order Service Initialized");
//    }

    public OrderService() {
        System.out.println("Default Order Service Constructor Called");
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        paymentService.pay();
    }

    public void getOrderDetails() {
        System.out.println("Fetching order details...");
    }
}

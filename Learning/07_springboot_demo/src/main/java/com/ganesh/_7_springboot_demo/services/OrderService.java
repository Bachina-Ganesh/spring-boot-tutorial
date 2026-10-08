package com.ganesh._7_springboot_demo.services;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service Constructor Called");
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed successfully!");
    }
}

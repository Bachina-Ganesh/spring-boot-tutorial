package com.ganesh.services;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private OrderService orderService;
    public PaymentService(OrderService orderService) {
        System.out.println("Payment Service Initialized");
        this.orderService = orderService;
    }

    public void pay() {
        System.out.println("Payment processed successfully!");
        orderService.getOrderDetails();
    }
}

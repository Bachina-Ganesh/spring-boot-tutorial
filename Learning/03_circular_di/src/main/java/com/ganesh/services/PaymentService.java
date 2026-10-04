package com.ganesh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    private OrderService orderService;
//    public PaymentService(OrderService orderService) {
//        System.out.println("Payment Service Initialized");
//        this.orderService = orderService;
//    }

    public PaymentService() {
        System.out.println("Default Payment Service Constructor Called");
    }

    public void pay() {
        System.out.println("Payment processed successfully!");
        orderService.getOrderDetails();
    }
}

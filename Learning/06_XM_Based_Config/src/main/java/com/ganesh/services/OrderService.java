package com.ganesh.services;

import org.springframework.beans.factory.BeanNameAware;

public class OrderService implements BeanNameAware {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service Created");
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        paymentService.pay();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }
}

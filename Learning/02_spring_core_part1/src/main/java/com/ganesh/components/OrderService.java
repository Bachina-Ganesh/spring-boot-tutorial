package com.ganesh.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {


    private  PaymentService paymentService;

    public OrderService() {
        System.out.println("Default order service constructor called");
    }

//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//        System.out.println("PaymentService injected via setter method");
//    }


    @Autowired
    public  OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("Parameterized order service constructor called");
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        paymentService.pay();
    }
}

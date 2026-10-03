package com.ganesh.services.orders;

import com.ganesh.services.payments.Payment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private final Payment payment;

    public OrderService(Payment payment) {
        this.payment = payment;
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        payment.pay();
    }
}

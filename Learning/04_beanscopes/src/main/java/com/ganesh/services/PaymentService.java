package com.ganesh.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Lazy
public class PaymentService {

    public PaymentService() {
        System.out.println("Default Payment Service Constructor Called");
    }

    public void pay() {
        System.out.println("Payment processed successfully!");
    }
}

package com.ganesh.services;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

//@Component
public class PaymentService implements BeanNameAware {

    static {
        System.out.println("Payment Service Class Loaded");
    }
    public PaymentService() {
        System.out.println("Payment service initialized");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }
}

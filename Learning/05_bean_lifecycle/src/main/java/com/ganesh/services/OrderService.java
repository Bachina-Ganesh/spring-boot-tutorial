package com.ganesh.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class OrderService implements BeanNameAware, ApplicationContextAware {

    private PaymentService paymentService;

    static {
        System.out.println("Order Service Class Loaded");
    }

    public OrderService(PaymentService paymentService) {
        System.out.println("Order Service Initialized");
        this.paymentService = paymentService;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Class<? extends ApplicationContext> cls = applicationContext.getClass();
        System.out.println("ApplicationContext class name is: " + cls);
    }
}

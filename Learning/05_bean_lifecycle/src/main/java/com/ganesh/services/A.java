package com.ganesh.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class A {

    private B b;
    public A(@Lazy B b) {
        this.b = b;
        System.out.println("A class constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("A class @PostConstruct method called");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("A class @PreDestroy method called");
    }

    public void call() {
        b.display();
    }
}

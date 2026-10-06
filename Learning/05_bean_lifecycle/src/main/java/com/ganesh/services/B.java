package com.ganesh.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;
    public B(A a) {
        this.a = a;
        System.out.println("B class constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("B class @PostConstruct method called");
    }

    public void display() {
        System.out.println("B class display method called");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("B class @PreDestroy method called");
    }
}

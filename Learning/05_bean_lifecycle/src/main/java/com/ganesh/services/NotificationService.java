package com.ganesh.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("prototype")
public class NotificationService /*implements InitializingBean, DisposableBean*/ {

    public NotificationService()
    {
        System.out.println("Notification Service Class created");
    }


//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Notification Service Initialized");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Notification Service Destroyed");
//    }

    @PostConstruct
    public void start() {
        System.out.println("Notification Service Initialized");
    }

    @PreDestroy
    public void stop() {
        System.out.println("Notification Service Destroyed");
    }
}

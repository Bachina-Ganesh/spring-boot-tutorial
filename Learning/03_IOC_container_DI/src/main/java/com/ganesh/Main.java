package com.ganesh;

import com.ganesh.config.AppConfig;
import com.ganesh.services.orders.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

        User user = context.getBean(User.class);
        System.out.println("User name: " + user.getName());
    }
}

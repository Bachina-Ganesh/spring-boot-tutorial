package com.ganesh._7_springboot_demo;

import com.ganesh._7_springboot_demo.services.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();
    }

}

package com.ganesh;

import com.ganesh.config.AppConfig;
import com.ganesh.services.OrderService;
import com.ganesh.services.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    static void main() {
        System.out.println("Main method called");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("ApplicationContext initialized1");
        OrderService orderService = context.getBean(OrderService.class);
//        PaymentService paymentService1 = context.getBean(PaymentService.class);
//        PaymentService paymentService2 = orderService.getPaymentService();
//        System.out.println(paymentService1);
//        System.out.println(paymentService2);
//        System.out.println(paymentService1 == paymentService2);

        System.out.println(orderService.getPaymentService());
        orderService.placeOrder();
        System.out.println(orderService.getPaymentService());
    }
}

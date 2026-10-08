package com.ganesh;

import com.ganesh.services.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ApplicationContext context = new ClassPathXmlApplicationContext("mainbeans.xml");

        OrderService orderService = context.getBean("orderService1", OrderService.class);
        OrderService orderService2 = context.getBean("orderService2", OrderService.class);
        orderService.placeOrder();
        orderService2.placeOrder();
    }
}

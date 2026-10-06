package com.ganesh;

import com.ganesh.config.AppConfig;
import com.ganesh.services.A;
import com.ganesh.services.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        NotificationService notificationService = context.getBean(NotificationService.class);
        A a = context.getBean(A.class);
        a.call();
        context.close();
    }
}

package com.ganesh.config;

import com.ganesh.services.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ganesh")
public class AppConfig {

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public NotificationService notificationService() {
//        return new NotificationService();
//    }
}

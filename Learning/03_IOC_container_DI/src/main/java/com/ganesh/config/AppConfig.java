package com.ganesh.config;

import com.ganesh.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ganesh")
public class AppConfig {

    @Bean
    public User user() {
        return new User("Ganesh", 20);
    }
}

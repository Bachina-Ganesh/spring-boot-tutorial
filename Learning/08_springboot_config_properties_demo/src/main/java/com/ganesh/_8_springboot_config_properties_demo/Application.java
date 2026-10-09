package com.ganesh._8_springboot_config_properties_demo;

import com.ganesh._8_springboot_config_properties_demo.services.PaymentGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final PaymentGateway paymentGateway;
    public Application(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Object Creations Completed");
    }

    @Override
    public void run(String... args) throws Exception {
        paymentGateway.pay();
    }
}

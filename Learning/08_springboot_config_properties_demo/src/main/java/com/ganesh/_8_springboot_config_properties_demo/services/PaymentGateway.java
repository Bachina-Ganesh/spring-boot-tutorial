package com.ganesh._8_springboot_config_properties_demo.services;

import com.ganesh._8_springboot_config_properties_demo.config_props.PaymentProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway implements BeanNameAware, InitializingBean {

    private final PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
        System.out.println("PaymentGateway Constructed");
    }

    public void pay() {
        if(paymentProperties.isEnabled()) {
            System.out.println("Payment processed successfully using " + paymentProperties.getType() + " gateway!");
            System.out.println("Retry Count: " + paymentProperties.getRetryCount());
        } else {
            System.out.println("Payment gateway is disabled.");
        }
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PaymentGateway 1");
    }

    @PostConstruct
    public void init() {
        System.out.println("PaymentGateway initialize");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PaymentGateway destroy");
    }
}

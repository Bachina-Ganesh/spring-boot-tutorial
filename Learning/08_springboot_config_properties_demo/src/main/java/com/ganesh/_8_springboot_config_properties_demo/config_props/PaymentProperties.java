package com.ganesh._8_springboot_config_properties_demo.config_props;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payment-gateway")
public class PaymentProperties implements BeanNameAware, InitializingBean {

    private String type;
    private int retryCount;
    private boolean enabled;

    public PaymentProperties() {
        System.out.println("PaymentProperties Constructed");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PaymentProperties 1");
    }

    @PostConstruct
    public void init() {
        System.out.println("PaymentProperties initialize");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PaymentProperties destroy");
    }

}

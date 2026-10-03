package com.ganesh.services.payments;

import org.springframework.stereotype.Component;

@Component("upi")
public class UPIPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Amount paid successfully using UPI!");
    }
}

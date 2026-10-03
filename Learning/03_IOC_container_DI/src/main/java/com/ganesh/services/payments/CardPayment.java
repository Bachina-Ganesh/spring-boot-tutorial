package com.ganesh.services.payments;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("card")
@Primary
public class CardPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Amount paid successfully using Card!");
    }
}

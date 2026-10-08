package com.ganesh.services;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Card Payment processed successfully!");
    }
}

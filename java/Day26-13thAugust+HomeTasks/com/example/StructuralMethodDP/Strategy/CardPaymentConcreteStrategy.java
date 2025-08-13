package com.example.StructuralMethodDP.Strategy;

/**
 * Concrete Strategy for Card payments.
 */
public class CardPaymentConcreteStrategy implements PaymentStrategy {
    @Override
    public void process(double price) {
        System.out.println("Processing payment of ₹" + price + " via Card");
    }
}

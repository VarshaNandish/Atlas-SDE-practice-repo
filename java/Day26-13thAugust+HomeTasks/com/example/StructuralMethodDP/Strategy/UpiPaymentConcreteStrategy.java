package com.example.StructuralMethodDP.Strategy;

/**
 * Concrete Strategy for UPI payments.
 */
public class UpiPaymentConcreteStrategy implements PaymentStrategy {
    @Override
    public void process(double price) {
        System.out.println("Processing payment of ₹" + price + " via UPI");
    }
}


package com.example.StructuralMethodDP.Strategy;

/**
 * Concrete Strategy for Cash payments.
 */
public class CashPaymentConcreteStrategy implements PaymentStrategy {
    @Override
    public void process(double price) {
        System.out.println("Processing payment of ₹" + price + " via Cash");
    }
}

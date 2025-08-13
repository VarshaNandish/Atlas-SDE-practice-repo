package com.example.StructuralMethodDP.Strategy;

/**
 * Context class - uses the selected PaymentStrategy.
 */
public class PaymentUsingStrategy {
    private PaymentStrategy paymentStrategy;

    public PaymentUsingStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void process(double price) {
        paymentStrategy.process(price);
    }
}

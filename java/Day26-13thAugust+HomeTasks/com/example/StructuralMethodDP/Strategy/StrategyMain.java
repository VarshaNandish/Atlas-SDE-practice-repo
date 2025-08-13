package com.example.StructuralMethodDP.Strategy;

public class StrategyMain {
    public static void main(String[] args) {
        System.out.println("Strategy Method Design Pattern - Behavioral DP\n");

        double amount = 500.0;

        // ----------------------------
        // 1. Old approach (No Strategy)
        // ----------------------------
        System.out.println("=== Old Approach (No Strategy) ===");
        Payments payments = new Payments();

        payments.setPaymentType(Payments.PaymentType.Cash);
        payments.process(amount);

        payments.setPaymentType(Payments.PaymentType.Cards);
        payments.process(amount);

        payments.setPaymentType(Payments.PaymentType.UPI);
        payments.process(amount);

        // ----------------------------
        // 2. Strategy Pattern Approach
        // ----------------------------
        System.out.println("\n=== Strategy Pattern Approach ===");

        PaymentUsingStrategy payment1 = new PaymentUsingStrategy(new CashPaymentConcreteStrategy());
        payment1.process(amount);

        PaymentUsingStrategy payment2 = new PaymentUsingStrategy(new CardPaymentConcreteStrategy());
        payment2.process(amount);

        PaymentUsingStrategy payment3 = new PaymentUsingStrategy(new UpiPaymentConcreteStrategy());
        payment3.process(amount);
    }
}

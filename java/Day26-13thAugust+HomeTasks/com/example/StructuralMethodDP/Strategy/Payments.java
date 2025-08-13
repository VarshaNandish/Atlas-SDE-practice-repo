package com.example.StructuralMethodDP.Strategy;

// Payments using - No strategy pattern
public class Payments {
    private PaymentType paymentType;

    public enum PaymentType {
        Cash,
        Cards,
        UPI
    }

    public void process(double price) {
        if (paymentType == PaymentType.Cash) {
            System.out.println("Processing payment of ₹" + price + " via Cash");
        }
        else if (paymentType == PaymentType.Cards) {
            System.out.println("Processing payment of ₹" + price + " via Card");
        }
        else if (paymentType == PaymentType.UPI) {
            System.out.println("Processing payment of ₹" + price + " via UPI");
        }
        else {
            throw new IllegalArgumentException("Sorry, invalid payment type");
        }
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}

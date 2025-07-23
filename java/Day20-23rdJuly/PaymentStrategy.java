public interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class BitcoinPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Bitcoin.");
    }
}

class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}

class MainPayment {
    public static void main(String[] args) {
        PaymentProcessor processor1 = new PaymentProcessor(new CreditCardPayment());
        processor1.processPayment(1500);

        PaymentProcessor processor2 = new PaymentProcessor(new PayPalPayment());
        processor2.processPayment(2000);

        PaymentProcessor processor3 = new PaymentProcessor(new BitcoinPayment());
        processor3.processPayment(3000);
    }
}


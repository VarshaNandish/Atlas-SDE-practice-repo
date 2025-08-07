package com.AdaptorMethodDP;

// Target Interface
interface Iphone {
    void onCharge();
    void offCharge();
}

// Adaptee Class - the existing class that needs adapting
class Iphone16Charger {

    public Iphone16Charger() {
        System.out.println("Iphone 16 charger ready");
    }

    public void charge() {
        System.out.println("I am charging Iphone 16");
    }

    public void removeCharge() {
        System.out.println("Stopped charging Iphone 16");
    }
}

// Adapter Interface - what Iphone expects to interact with
interface Charger {
    void charge();
    void removeCharge();
}

// Adapter Class - bridges Iphone16Charger to the Charger interface
class Iphone16Adapter implements Charger {

    private Iphone16Charger iphone16Charger;

    public Iphone16Adapter() {
        this.iphone16Charger = new Iphone16Charger();
    }

    @Override
    public void charge() {
        iphone16Charger.charge();
    }

    @Override
    public void removeCharge() {
        iphone16Charger.removeCharge();
    }
}

// Client Class - uses the Charger interface
class Iphone16 implements Iphone {

    private Charger charger;

    public Iphone16(Charger charger) {
        this.charger = charger;
    }

    @Override
    public void onCharge() {
        charger.charge();
    }

    @Override
    public void offCharge() {
        charger.removeCharge();
    }
}

// Main class to test the Adapter pattern
public class AdapterDPDriver {

    public static void main(String[] args) {
        Iphone iphone = new Iphone16(new Iphone16Adapter());

        iphone.onCharge();     // Charging starts
        iphone.offCharge();    // Charging stops
    }
}


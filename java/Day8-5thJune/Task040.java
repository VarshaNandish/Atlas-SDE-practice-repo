// Abstract class representing Gadgets
abstract class Gadget {
    abstract void turnOn();
    abstract void turnOff();
}

// Concrete class for TV Remote
class TVRemotes extends Gadget {
    @Override
    void turnOn() {
        System.out.println("TV is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}

// Concrete class for AC Remote
class ACRemote extends Gadget {
    @Override
    void turnOn() {
        System.out.println("AC is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("AC is turned OFF.");
    }
}

// Concrete class for Fan Remote
class FanRemote extends Gadget {
    @Override
    void turnOn() {
        System.out.println("Fan is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("Fan is turned OFF.");
    }
}

// Concrete class for Cooler Remote
class CoolerRemote extends Gadget {
    @Override
    void turnOn() {
        System.out.println("Cooler is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("Cooler is turned OFF.");
    }
}

// Main class to demonstrate abstraction
public class Task040 {
    public static void main(String[] args) {
        Gadget tv = new TVRemotes();
        tv.turnOn();
        tv.turnOff();

        Gadget ac = new ACRemote();
        ac.turnOn();
        ac.turnOff();

        Gadget fan = new FanRemote();
        fan.turnOn();
        fan.turnOff();

        Gadget cooler = new CoolerRemote();
        cooler.turnOn();
        cooler.turnOff();
    }
}

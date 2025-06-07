abstract class Gadgets {
    abstract void turnOn();
    abstract void turnOff();
}
class TVRemote extends Gadgets {
    @Override
    void turnOn() {
        System.out.println("TV is turned ON.");
    }
    @Override
    void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}
public class Task40 {
    public static void main(String[] args) {
        Gadgets remote = new TVRemote();
        remote.turnOn();
        remote.turnOff();
    }
}

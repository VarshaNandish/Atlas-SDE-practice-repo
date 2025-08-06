package SuperPowers;

public class IronMan extends HumanBeing {

    public IronMan() {
        this.name = "IronMan";
        this.type = "SuperHero";
    }

    public void fly() {
        System.out.println(name + " is flying");
    }

    public void intelligent() {
        System.out.println(name + " is intelligent");
    }

    public void fireShots() {
        System.out.println(name + " is firing shots");
    }

    public void defendHimself() {
        System.out.println(name + " is defending himself");
    }
}


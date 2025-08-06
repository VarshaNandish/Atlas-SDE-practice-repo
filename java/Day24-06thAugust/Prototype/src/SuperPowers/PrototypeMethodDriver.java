package SuperPowers;

public class PrototypeMethodDriver {
    public static void main(String[] args) {
        CloneOfHuman.loadCache();

        HumanBeing human1 = CloneOfHuman.getClone("1");
        System.out.println("Cloned: " + human1.getName());
        human1.walk();

        HumanBeing human2 = CloneOfHuman.getClone("2");
        System.out.println("Cloned: " + human2.getName());
        human2.see();

        HumanBeing human3 = CloneOfHuman.getClone("3");
        System.out.println("Cloned: " + human3.getName());
        human3.talk();

        System.out.println("Total cached types: " + CloneOfHuman.getSize());
    }
}


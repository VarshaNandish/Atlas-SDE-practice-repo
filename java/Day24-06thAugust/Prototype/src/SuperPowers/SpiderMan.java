package SuperPowers;

public class SpiderMan extends HumanBeing {

    public SpiderMan() {
        this.name = "SpiderMan";
        this.type = "SuperHero";
    }

    public void crawling() {
        System.out.println(name + " is crawling on the wall");
    }

    public void throwingWeb() {
        System.out.println(name + " is throwing web");
    }
}


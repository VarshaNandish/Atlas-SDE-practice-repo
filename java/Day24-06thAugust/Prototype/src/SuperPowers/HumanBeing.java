package SuperPowers;

public abstract class HumanBeing implements Cloneable {
    protected String name;
    protected String type;

    public void walk() {
        System.out.println(name + " is walking");
    }

    public void see() {
        System.out.println(name + " is seeing");
    }

    public void talk() {
        System.out.println(name + " is talking");
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}


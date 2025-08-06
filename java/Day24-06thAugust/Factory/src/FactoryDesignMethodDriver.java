public class FactoryDesignMethodDriver {
    public static void main(String[] args) {
        PizzaFactory cheezyFactory = new CheezyPizzaFactory();
        Pizza cheezyPizza = cheezyFactory.createPizza();
        cheezyPizza.prepare();
        cheezyPizza.bake();
        cheezyPizza.cut();
        cheezyPizza.box();

        System.out.println();

        PizzaFactory pepperoniFactory = new PepperoniPizzaFactory();
        Pizza pepperoniPizza = pepperoniFactory.createPizza();
        pepperoniPizza.prepare();
        pepperoniPizza.bake();
        pepperoniPizza.cut();
        pepperoniPizza.box();
    }
}

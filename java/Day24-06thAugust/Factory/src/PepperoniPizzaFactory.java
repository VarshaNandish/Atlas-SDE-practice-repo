public class PepperoniPizzaFactory extends PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new PepperoniPizza();
    }
}


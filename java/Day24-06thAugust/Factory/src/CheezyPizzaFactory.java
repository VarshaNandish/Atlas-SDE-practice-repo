public class CheezyPizzaFactory extends PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new CheezyPizza();
    }
}

public class CheezyPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Cheezy Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheezy Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Cheezy Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Cheezy Pizza");
    }
}

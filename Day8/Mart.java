class Customer {
    int cost = 40;
    String items = "Tomatoes";

    void purchaseList() {
        System.out.println("Customer Items: " + items);
        System.out.println("Customer Cost: " + cost);
    }
}

class Mart extends Customer {

    void billing() {
        String items = "Onions";
        int cost = 30;

        System.out.println("Billing Items (local): " + items);
        System.out.println("Billing Cost (local): " + cost);

        // Using super to access parent class variables
        System.out.println("Billing Items (from super): " + super.items);
        System.out.println("Billing Cost (from super): " + super.cost);
    }

    public static void main(String[] args) {
        Mart obj = new Mart();

        // Modify parent class variables through object
        obj.items = "Potatoes";
        obj.cost = 50;

        System.out.println("Items (inherited): " + obj.items);
        System.out.println("Cost (inherited): " + obj.cost);

        obj.purchaseList(); // inherited method
        obj.billing();
    }
}
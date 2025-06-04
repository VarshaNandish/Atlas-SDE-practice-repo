public class Task07 {
    public static void main(String[] args) {
        // Creating an object of Customer class
        Customer customer = new Customer();

        // Calling method of Customer class using the object
        customer.showCustomerDetails();
    }
}

// Customer class
class Customer {
    // Method inside Customer class
    public void showCustomerDetails() {
        System.out.println("Customer details are being displayed.");
    }
}

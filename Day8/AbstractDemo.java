public class AbstractDemo {
    public static void main(String[] args) {
        BaseEmployee e = new SalariedEmployee("George W.", "Houston, TX", 43, 5000.00);

        System.out.println("\nCall mailCheck using BaseEmployee reference--");
        e.mailCheck();
    }
}

abstract class BaseEmployee {
    private String name;
    private String address;
    private int number;

    public BaseEmployee(String name, String address, int number) {
        System.out.println("Constructing a BaseEmployee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public abstract double computePay();

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " at " + address);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class SalariedEmployee extends BaseEmployee {
    private double salary;

    public SalariedEmployee(String name, String address, int number, double salary) {
        super(name, address, number);
        this.salary = salary;
    }

    @Override
    public double computePay() {
        return salary / 12;
    }

    @Override
    public void mailCheck() {
        System.out.println("Mailing check to salaried employee: " + getName());
        System.out.println("Monthly Pay: $" + computePay());
    }
}
class Customers {
    void accept() {
        System.out.println("accept customer called");
    }

    void display() {
        System.out.println("display customer called");
    }
}

public class Test007 {
    public static void main(String[] args) {
        Customers cobj = new Customers();
        cobj.accept();
        cobj.display();
    }
}
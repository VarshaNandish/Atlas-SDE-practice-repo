class Employee {
    private int pwd;
    protected int salary;
    public int empid;


    public Employee() {
    }
    public int getPwd() {
        return pwd;
    }
    public void setPwd(int pwd) {
        this.pwd = pwd;
    }
}

class Hr extends Employee {
    public Hr() {

        setPwd(1254);

        super.salary = 50000;
        super.empid = 10001;
    }

    public void display() {
        System.out.println("Pwd: " + getPwd());
        System.out.println("Salary: " + salary);
        System.out.println("Empid: " + empid);
    }
}

public class Main {
    public static void main(String[] args) {
        Hr hr = new Hr();
        hr.display();
    }
}

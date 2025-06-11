class Person {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}


class Employee extends Person {
    private String department;
    private double salary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String dept) {
        this.department = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double sal) {
        this.salary = sal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department + ", Salary: " + salary;
    }
}


class Manager extends Employee {
    private int teamSize;
    private String level;

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int size) {
        this.teamSize = size;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String lvl) {
        this.level = lvl;
    }

    @Override
    public String toString() {
        return super.toString() + ", Team Size: " + teamSize + ", Level: " + level;
    }
}


public class Task14 {
    public static void main(String[] args) {
        Manager manager = new Manager();


        manager.setName("Varsha");
        manager.setId(111);
        manager.setDepartment("IT");
        manager.setSalary(850000.50);
        manager.setTeamSize(5);
        manager.setLevel("Senior");


        System.out.println(manager.toString());
    }
}

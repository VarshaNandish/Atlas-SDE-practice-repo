import java.util.HashMap;

public class HashMap2Obj {
    public static void main(String[] args) {

        HashMap<String, Integer> studentAges = new HashMap<>();
        studentAges.put("Alice", 25);
        studentAges.put("Bob", 30);
        studentAges.put("Charlie", 28);
        System.out.println("Student Ages - Bob's Age: " + studentAges.get("Bob"));
        System.out.println("\nStudent Ages Map:" + studentAges);
        //for (String name : studentAges.keySet()) {
        //    System.out.println(name + " → " + studentAges.get(name));
        //}

        HashMap<String, Integer> employeeAges = new HashMap<>();
        employeeAges.put("David", 35);
        employeeAges.put("Emma", 29);
        employeeAges.put("Frank", 40);
        System.out.println("\nEmployee Ages - Emma's Age: " + employeeAges.get("Emma"));
        System.out.println("\nEmployee Ages Map:");
        for (String name : employeeAges.keySet()) {
            System.out.println(name + " → " + employeeAges.get(name));
        }
    }
}


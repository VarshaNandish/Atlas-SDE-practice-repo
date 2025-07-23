public class Employee {
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

}

class ReportGenerator {
    public void generatePdfReport(Employee employee) {
        System.out.println("Generating PDF report for " + employee.getName());
    }
}

class EmailService {
    public void sendEmail(Employee employee) {
        System.out.println("Sending email to " + employee.getEmail());
    }
}

class MainEmployee {
    public static void main(String[] args) {
        Employee emp = new Employee("Varsha", "varsha@example.com", 100000);

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generatePdfReport(emp);

        EmailService emailService = new EmailService();
        emailService.sendEmail(emp);
    }
}







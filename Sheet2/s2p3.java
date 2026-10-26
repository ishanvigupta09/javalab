
class Employee {
    private int empId;
    private String name;
    private double basicSalary;

    // Constructor
    Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Calculate gross salary
    public double calculateGrossSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        double bonus = 0;

        if (basicSalary > 50000) {
            bonus = basicSalary * 0.05;
        }

        return basicSalary + hra + da + bonus;
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: Rs. " + basicSalary);
        System.out.println("Gross Salary: Rs. " + calculateGrossSalary());
        System.out.println("-----------------------------");
    }

    // Compare two employees
    public static Employee compareEmployees(Employee e1, Employee e2) {
        if (e1.calculateGrossSalary() >= e2.calculateGrossSalary()) {
            return e1;
        } else {
            return e2;
        }
    }

    public String getName() {
        return name;
    }
}

public class s2p3 {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Aamir", 40000);
        Employee e2 = new Employee(102, "Sara", 60000);
        Employee e3 = new Employee(103, "Rahul", 80000);

        System.out.println("EMPLOYEE SALARY DETAILS");
        System.out.println("=============================");

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();

        Employee higher = Employee.compareEmployees(e1, e2);
        System.out.println("Higher Salary between Aamir and Sara: "
                + higher.getName());

        Employee highest = Employee.compareEmployees(e2, e3);
        System.out.println("Higher Salary between Sara and Rahul: "
                + highest.getName());
    }
}

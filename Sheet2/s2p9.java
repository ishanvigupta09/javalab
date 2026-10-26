
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Display employee details
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs. " + salary);
        System.out.println("-------------------------");
    }
}

public class s2p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input employee details
        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details of Employee " + i);

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees.add(new Employee(id, name, department, salary));
        }

        // Sort by salary in ascending order
        Collections.sort(employees,
                Comparator.comparingDouble(Employee::getSalary));

        System.out.println("\nEmployees Sorted by Salary (Ascending):");
        for (Employee e : employees) {
            e.display();
        }

        // Sort by name alphabetically
        Collections.sort(employees,
                Comparator.comparing(Employee::getName,
                        String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nEmployees Sorted by Name:");
        for (Employee e : employees) {
            e.display();
        }

        // Search employees by department
        System.out.print("\nEnter department to search: ");
        String searchDept = sc.nextLine();

        boolean found = false;
        System.out.println("\nEmployees in " + searchDept + " Department:");

        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(searchDept)) {
                e.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in this department.");
        }

        // Sort salary in descending order
        employees.sort(
                Comparator.comparingDouble(Employee::getSalary).reversed());

        // Display top three highest-paid employees
        System.out.println("\nTop 3 Highest-Paid Employees:");

        int limit = Math.min(3, employees.size());

        for (int i = 0; i < limit; i++) {
            employees.get(i).display();
        }

        sc.close();
    }
}

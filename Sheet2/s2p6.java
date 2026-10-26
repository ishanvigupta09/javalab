
import java.util.HashSet;
import java.util.Scanner;

class Student {
    private int regNo;
    private String name;

    // Constructor
    Student(int regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public int getRegNo() {
        return regNo;
    }

    // Compare students using registration number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student s = (Student) obj;
        return regNo == s.regNo;
    }

    // Generate hash code using registration number
    @Override
    public int hashCode() {
        return Integer.hashCode(regNo);
    }

    public void display() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("--------------------");
    }
}

public class s2p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> students = new HashSet<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details of student " + i);

            System.out.print("Registration Number: ");
            int regNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            Student s = new Student(regNo, name);

            if (students.add(s)) {
                System.out.println("Student registered successfully!");
            } else {
                System.out.println("Duplicate registration number! Student not added.");
            }
        }

        // Check whether a student is registered
        System.out.print("\nEnter registration number to search: ");
        int searchRegNo = sc.nextInt();

        Student searchStudent = new Student(searchRegNo, "");

        if (students.contains(searchStudent)) {
            System.out.println("Student is already registered.");
        } else {
            System.out.println("Student is not registered.");
        }

        // Display all registered students
        System.out.println("\nRegistered Students:");
        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseName;
    private int capacity;

    Course(String courseCode, String courseName, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.capacity = capacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Student {
    private String studentId;
    private String name;

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class RegistrationSystem {
    private HashMap<String, Course> courses = new HashMap<>();

    private HashMap<String, ArrayList<Student>> registrations =
            new HashMap<>();

    // Add a course
    public void addCourse(Course course) {
        String code = course.getCourseCode();

        if (courses.containsKey(code)) {
            System.out.println("Course already exists!");
            return;
        }

        courses.put(code, course);
        registrations.put(code, new ArrayList<Student>());

        System.out.println("Course added successfully!");
    }

    // Register a student
    public void registerStudent(String courseCode, Student student) {
        if (!courses.containsKey(courseCode)) {
            System.out.println("Course not found!");
            return;
        }

        ArrayList<Student> list = registrations.get(courseCode);
        Course course = courses.get(courseCode);

        // Check duplicate registration
        for (Student s : list) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Student already registered in this course!");
                return;
            }
        }

        // Check course capacity
        if (list.size() >= course.getCapacity()) {
            System.out.println("Course is full! Registration rejected.");
            return;
        }

        list.add(student);
        System.out.println("Student registered successfully!");
    }

    // Display students in a course
    public void displayStudents(String courseCode) {
        if (!courses.containsKey(courseCode)) {
            System.out.println("Course not found!");
            return;
        }

        Course course = courses.get(courseCode);
        ArrayList<Student> list = registrations.get(courseCode);

        System.out.println("\nCourse: " + course.getCourseName());
        System.out.println("Course Code: " + courseCode);
        System.out.println("Enrolled Students:");

        if (list.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student s : list) {
            System.out.println("Student ID: " + s.getStudentId()
                    + ", Name: " + s.getName());
        }
    }
}

public class s2p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationSystem system = new RegistrationSystem();

        int choice;

        do {
            System.out.println("\n===== COURSE REGISTRATION =====");
            System.out.println("1. Add Course");
            System.out.println("2. Register Student");
            System.out.println("3. Display Course Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter course code: ");
                    String code = sc.nextLine();

                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();

                    System.out.print("Enter maximum capacity: ");
                    int capacity = sc.nextInt();
                    sc.nextLine();

                    if (capacity <= 0) {
                        System.out.println("Capacity must be positive!");
                        break;
                    }

                    system.addCourse(
                            new Course(code, courseName, capacity));
                    break;

                case 2:
                    System.out.print("Enter course code: ");
                    String regCode = sc.nextLine();

                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    system.registerStudent(
                            regCode, new Student(id, name));
                    break;

                case 3:
                    System.out.print("Enter course code: ");
                    String displayCode = sc.nextLine();

                    system.displayStudents(displayCode);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

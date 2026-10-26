
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Patient {
    private int patientId;
    private String name;
    private int priority;
    private int arrivalOrder;

    // Constructor
    Patient(int patientId, String name, int priority, int arrivalOrder) {
        this.patientId = patientId;
        this.name = name;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void display() {
        String status;

        if (priority == 1) {
            status = "Critical";
        } else if (priority == 2) {
            status = "Urgent";
        } else {
            status = "Normal";
        }

        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Priority: " + priority + " (" + status + ")");
        System.out.println("------------------------");
    }
}

public class s2p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Smaller priority first; earlier arrival breaks ties
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            Comparator.comparingInt(Patient::getPriority)
                .thenComparingInt(Patient::getArrivalOrder)
        );

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details of patient " + i);

            System.out.print("Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Priority (1=Critical, 2=Urgent, 3=Normal): ");
            int priority = sc.nextInt();
            sc.nextLine();

            if (priority < 1 || priority > 3) {
                System.out.println("Invalid priority! Enter 1, 2, or 3.");
                i--;
                continue;
            }

            Patient p = new Patient(id, name, priority, i);
            queue.add(p);

            System.out.println("Patient added to queue!");
        }

        // Process patients according to priority
        System.out.println("\nPatient Processing Order:");
        System.out.println("========================");

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            p.display();
        }

        sc.close();
    }
}

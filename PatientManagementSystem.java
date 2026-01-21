import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}

public class PatientManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Patient Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    System.out.println("Thank you. Program ended.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\n--- Patient List ---");
        for (Patient p : patients) {
            System.out.println("ID: " + p.id +
                    ", Name: " + p.name +
                    ", Age: " + p.age +
                    ", Disease: " + p.disease);
        }
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient Found");
                System.out.println("Name: " + p.name);
                System.out.println("Age: " + p.age);
                System.out.println("Disease: " + p.disease);
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                patients.remove(p);
                System.out.println("Patient deleted successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }
}
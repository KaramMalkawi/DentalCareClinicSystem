package dentalCareClinicSystem;

import java.util.Scanner;

public class ClinicFacade {
    private final Doctor doctor;
    private final Nurse nurse;
    private final Receptionist receptionist;
    private final Scanner scanner;

    public ClinicFacade() {
        // Initialize the doctor, nurse, receptionist, and scanner
        doctor = Doctor.getInstance("Ali", "Amman", 53, "Doctor Contact Number", "Doctor");
        nurse = Nurse.getInstance("Hala", "Irbid", 55, "Nurse Contact Number", "Nurse");
        receptionist = Receptionist.getInstance("Mahmood", "Aqaba", 8, "Receptionist Contact Number", "Receptionist");
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Please choose your role:");
            System.out.println("1. Doctor");
            System.out.println("2. Nurse");
            System.out.println("3. Receptionist");
            System.out.println("0. Exit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine(); // Consume the newline character
                continue;
            }

            switch (choice) {
                case 1:
                    handleDoctor();
                    break;
                case 2:
                    handleNurse();
                    break;
                case 3:
                    handleReceptionist();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleDoctor() {
        while (true) {
            System.out.println("Doctor Functionality:");
            System.out.println("1. Add medicine to a patient");
            System.out.println("2. Add treatment description to a patient");
            System.out.println("0. Exit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine(); // Consume the newline character
                continue;
            }

            switch (choice) {
                case 1:
                    doctor.addMedicine();
                    break;
                case 2:
                    doctor.addTreatmentDescription();
                    break;
                case 0:
                    System.out.println("Exiting doctor functionality...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleNurse() {
        while (true) {
            System.out.println("Nurse Functionality:");
            System.out.println("1. Issue report for an appointment");
            System.out.println("0. Exit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine(); // Consume the newline character
                continue;
            }

            switch (choice) {
                case 1:
                    nurse.issueReport();
                    break;
                case 0:
                    System.out.println("Exiting nurse functionality...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleReceptionist() {
        while (true) {
            System.out.println("Receptionist Functionality:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Calculate bill");
            System.out.println("3. Print appointments");
            System.out.println("0. Exit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine(); // Consume the newline character
                continue;
            }

            switch (choice) {
                case 1:
                    receptionist.addPatient();
                    break;
                case 2:
                    System.out.print("Enter the patient's national number: ");
                    int nationalNumber = scanner.nextInt();
                    receptionist.getBill(nationalNumber);
                    break;
                case 3:
                    receptionist.printAppointments();
                    break;
                case 0:
                    System.out.println("Exiting receptionist functionality...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

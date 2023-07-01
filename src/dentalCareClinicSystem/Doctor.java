package dentalCareClinicSystem;

import java.util.Scanner;

public class Doctor extends Stuff implements DoctorInterface {

    Scanner scanner = new Scanner(System.in);
    private static Doctor instance = null;

    private Doctor(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
        super(name, address, nationalNumber, phoneNumber, jobDescription);
    }

    public static Doctor getInstance(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
        if (instance == null) {
            instance = new Doctor(name, address, nationalNumber, phoneNumber, jobDescription);
        }
        return instance;
    }

    // Adds a new medicine to a patient's prescription.
    @Override
    public void addMedicine() {
        System.out.print("Enter the patient's national number: ");
        int nationalNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the medicine name: ");
        String medicineName = scanner.nextLine();

        System.out.print("Enter the medicine dose: ");
        int dose;
        try {
            dose = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the newline character
            return;
        }

        // Find the target patient using their national number
        Patient targetPatient = findPatientByNationalNumber(getPatientRecords(), nationalNumber);
        if (targetPatient != null) {
            // Create a new Medicine object with the provided details
            Medicine newMedicine = new Medicine(medicineName, dose);
            // Add the medicine to the patient's prescription
            targetPatient.addMedicine(newMedicine);
            System.out.println("Medicine added to the patient successfully.");
        } else {
            System.out.println("Patient with the provided national number not found.");
        }
    }

    //Adds a treatment description to a patient's record.
    @Override
    public void addTreatmentDescription() {
        System.out.print("Enter the patient's national number: ");
        int nationalNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Enter the treatment description: ");
        String newTreatmentDescription = scanner.nextLine();
        
        // Find the target patient using their national number
        Patient targetPatient = findPatientByNationalNumber(getPatientRecords(), nationalNumber);
        if (targetPatient != null) {
            // Set the treatment description for the patient
            targetPatient.setTreatmentDescription(newTreatmentDescription);
            System.out.println("Treatment description added to the patient successfully.");
        } else {
            System.out.println("Patient with the provided national number not found.");
        }
    }
    
}

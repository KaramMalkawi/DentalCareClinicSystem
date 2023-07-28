package dentalCareClinicSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Receptionist extends Stuff implements ReceptionistInterface {

    Scanner scanner = new Scanner(System.in);

    private static Receptionist instance = null;
    private ArrayList<Patient> patients;
    
    // Private constructor to ensure the Receptionist class follows the Singleton pattern
    private Receptionist(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
        super(name, address, nationalNumber, phoneNumber, jobDescription);
        patients = new ArrayList<>();
    }

    // Static method to retrieve the singleton instance of the Receptionist class
    public static Receptionist getInstance(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
        if (instance == null) {
            instance = new Receptionist(name, address, nationalNumber, phoneNumber, jobDescription);
        }
        return instance;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    // Adds a new patient to the system.
    @Override
    public void addPatient() {
        System.out.println("Enter patient details:");
        System.out.print("Patient Name: ");
        String patientName = scanner.nextLine();
        
        System.out.print("Patient Address: ");
        String patientAddress = scanner.nextLine();
        
        System.out.print("Patient Phone Number: ");
        String patientPhoneNumber = scanner.nextLine();
        
        int patientNationalNumber;
        do {
            System.out.print("Receptionist National Number: ");
            patientNationalNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            // Check if a patient with the provided national number already exists
            if (findPatientByNationalNumber(getPatientRecords(), patientNationalNumber) != null) {
                System.out.println("Patient with the provided national number already exists. Please enter a unique national number.");
            }
        } while (findPatientByNationalNumber(getPatientRecords(), patientNationalNumber) != null);
        
        System.out.print("Patient Type (1- Dentist Student / 2- Ordinary Patient / 3- Dental Consultant): ");
        String type = scanner.next();
        
        double appointment;
        if (getPatients().isEmpty()) {
            // If there are no existing patients, set the initial appointment time to 10:00 AM
            appointment = 10.00;
        } else {
            // Get the last patient's appointment time
            Patient lastPatient = getPatients().get(getPatients().size() - 1);
            double lastAppointment = lastPatient.getAppointment();
            
            // Calculate the next appointment time slot based on the previous appointment
            if (lastAppointment % 1 == 0) {
                appointment = lastAppointment + 0.30;
            } else {
                appointment = lastAppointment + 0.70;
            }
            
            // Check if the next appointment exceeds the maximum appointment time (18.30)
            if (appointment >= 18.30) {
                System.out.println("No more available appointments for the day.");
                return;
            }
        }
        
        Patient newPatient;
        if (type.equals("1")) {
            // Create a new DentistStudent patient using the Strategy pattern
            Context context = new Context(new DentistStudent(patientName, patientAddress, patientNationalNumber, patientPhoneNumber, appointment));
            context.executeStrategy();
            newPatient = (Patient) context.getStrategy();
        } else if (type.equals("2")) {
            // Create a new OrdinaryPatient patient using the Strategy pattern
            Context context = new Context(new OrdinaryPatient(patientName, patientAddress, patientNationalNumber, patientPhoneNumber, appointment));
            context.executeStrategy();
            newPatient = (Patient) context.getStrategy();
        } else if (type.equals("3")) {
            // Create a new DentalConsultant patient using the Strategy pattern
            Context context = new Context(new DentalConsultant(patientName, patientAddress, patientNationalNumber, patientPhoneNumber, appointment));
            context.executeStrategy();
            newPatient = (Patient) context.getStrategy();
        } else {
            // Handle unknown patient type
            System.out.println("Invalid patient type. Patient not added.");
            return;
        }
        
        // Add the patient to the patientRecords list
        getPatientRecords().add(newPatient);
        
        // Set the patients in the receptionist instance
        setPatients(getPatientRecords());
    }
    
    // Calculates and retrieves the bill for a patient based on their national number. 
    @Override
    public int getBill(int nationalNumber) {
    	
        Patient patient = findPatientByNationalNumber(getPatientRecords(), nationalNumber);
        if (patient != null) {
            Strategy strategy = null;
            
            if (patient.getType().equals("Ordinary Patient")) {
                // Create a new OrdinaryPatient object to calculate the bill
                strategy = new OrdinaryPatient(patient.getName(), patient.getAddress(), patient.getNationalNumber(), patient.getPhoneNumber(), patient.getAppointment());
            } else if (patient.getType().equals("Dental Consultant")) {
                // Create a new DentalConsultant object to calculate the bill
                strategy = new DentalConsultant(patient.getName(), patient.getAddress(), patient.getNationalNumber(), patient.getPhoneNumber(), patient.getAppointment());
            } else if (patient.getType().equals("Dentist Student")) {
                // Create a new DentistStudent object to calculate the bill
                strategy = new DentistStudent(patient.getName(), patient.getAddress(), patient.getNationalNumber(), patient.getPhoneNumber(), patient.getAppointment());
            } else {
                System.out.println("Invalid type");
            }
            
            if (strategy != null) {
                int bill = strategy.calculateBill();
                System.out.println("Patient name: " + patient.getName());
                System.out.println("Total Bill: " + bill + " JD");
                return bill;
            }
        }
        
        System.out.println("Patient with the provided national number not found.");
        return 0;
    }
    
    // Prints the appointments of all patients.
    @Override
    public void printAppointments() {
        int size = patients.size();
        
        for (int i = 0; i < size; i++) {
            Patient patient = patients.get(i);
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Appointment Time: " + patient.getAppointment() + "0");
        }
    }
    
}

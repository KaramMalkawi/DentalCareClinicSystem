package dentalCareClinicSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Nurse extends Stuff implements NurseInterface {

    Scanner scanner = new Scanner(System.in);
    private static Nurse instance = null;

    private Nurse(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
        super(name, address, nationalNumber, phoneNumber, jobDescription);
    }

    public static Nurse getInstance(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
        if (instance == null) {
            instance = new Nurse(name, address, nationalNumber, phoneNumber, jobDescription);
        }
        return instance;
    }

    // Generates and saves a nurse report containing patient information and treatment details.
    @Override
    public void issueReport() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Nurse Report.txt");
            fileWriter.write("Nurse Report:\n");

            // Iterate through the patient records
            for (int i = 0; i < getPatientRecords().size(); i++) {
                Patient patient = getPatientRecords().get(i);

                // Write patient details to the report file
                fileWriter.write("Name: " + patient.getName() + "\n");
                fileWriter.write("Address: " + patient.getAddress() + "\n");
                fileWriter.write("National Number: " + patient.getNationalNumber() + "\n");
                fileWriter.write("Phone Number: " + patient.getPhoneNumber() + "\n");
                fileWriter.write("Appointment Time: " + patient.getAppointment() + "0\n");

                // Check if patient has treatment description and medicine
                if (patient.getTreatmentDescription() != null && patient.getMedicine() != null) {
                    fileWriter.write("Treatment Description: " + patient.getTreatmentDescription() + "\n");
                    fileWriter.write("Medicine: " + patient.getMedicine() + "\n");
                }
            }

            System.out.println("Nurse report saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving the nurse report.");
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error occurred while closing the file writer.");
                    e.printStackTrace();
                }
            }
        }
    }
    
}

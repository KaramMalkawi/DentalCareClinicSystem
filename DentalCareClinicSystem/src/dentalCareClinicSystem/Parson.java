package dentalCareClinicSystem;

import java.util.ArrayList;

public class Parson {

	private String name;
	private String address;
	private int nationalNumber;
	private String phoneNumber;
	private static ArrayList<Patient> patientRecords = new ArrayList<>();

	public Parson(String name, String address, int nationalNumber, String phoneNumber, double appointment) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
		this.nationalNumber = nationalNumber;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNationalNumber() {
		return nationalNumber;
	}

	public void setNationalNumber(int nationalNumber) {
		this.nationalNumber = nationalNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static ArrayList<Patient> getPatientRecords() {
		return patientRecords;
	}

	public static void setPatientRecords(ArrayList<Patient> patientRecords) {
		Parson.patientRecords = patientRecords;
	}

	public static Patient findPatientByNationalNumber(ArrayList<Patient> patientRecords, int nationalNumber) {
        for (int i = 0; i < patientRecords.size(); i++) {
            Patient patient = patientRecords.get(i);
            if (patient.getNationalNumber() == nationalNumber)
                return patient;
        }
        return null;
    }
	
}

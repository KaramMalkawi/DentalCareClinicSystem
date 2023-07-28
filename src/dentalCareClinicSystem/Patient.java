package dentalCareClinicSystem;

import java.util.ArrayList;

public class Patient extends Parson {

    private String type;
    private int fees;
    private int discount;
    private ArrayList<Medicine> medicines;
    private String treatmentDescription;
    private double appointment;

    public Patient(String name, String address, int nationalNumber, String phoneNumber, double appointment) {
        super(name, address, nationalNumber, phoneNumber, nationalNumber);
        this.appointment = appointment;
        this.medicines = new ArrayList<>();
        this.treatmentDescription = " ";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public ArrayList<Medicine> getMedicine() {
        return medicines;
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public double getAppointment() {
        return appointment;
    }

    public void setAppointment(double appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Patient [name=" + getName() + ", address=" + getAddress() + ", nationalNumber=" + getNationalNumber()
                + ", Phone Number=" + getPhoneNumber() + ", type=" + type + ", fees=" + fees + ", discount=" + discount
                + ", appointment=" + appointment + ", medicines=" + medicines + ", Treatment Description="
                + treatmentDescription + "]";
    }
}

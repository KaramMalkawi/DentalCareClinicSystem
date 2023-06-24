package dentalCareClinicSystem;

public class DentistStudent extends Patient implements Strategy {
	
    public DentistStudent(String name, String address, int patientNationalNumber, String phoneNumber, double appointment) {
		super(name, address, patientNationalNumber, phoneNumber, appointment);
        setType("Dentist Student");
        setFees(30);
        setDiscount(50);
    }


	@Override
	public int calculateBill() {
        return getFees() - (getFees() * getDiscount() / 100);
	}

}

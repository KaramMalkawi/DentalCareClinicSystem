package dentalCareClinicSystem;

public class OrdinaryPatient extends Patient implements Strategy  {
	
    public OrdinaryPatient(String name, String address, int patientNationalNumber, String phoneNumber, double appointment) {
		super(name, address, patientNationalNumber, phoneNumber, appointment);
        setType("Ordinary Patient");
        setFees(30);
        setDiscount(0);
	}

	@Override
	public int calculateBill() {
        return getFees() - (getFees() * getDiscount() / 100);
	}
	
}

package dentalCareClinicSystem;

public class DentalConsultant extends Patient implements Strategy {
	
    public DentalConsultant(String name, String address, int patientNationalNumber, String phoneNumber, double appointment) {
		super(name, address, patientNationalNumber, phoneNumber, appointment);
        setType("Dental Consultant");
        setFees(30);
        setDiscount(20);
	}
    
	@Override
	public int calculateBill() {
        return getFees() - (getFees() * getDiscount() / 100);
	}

}

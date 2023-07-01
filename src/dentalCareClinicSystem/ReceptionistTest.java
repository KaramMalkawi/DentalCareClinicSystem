package dentalCareClinicSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceptionistTest {

	@Test
	void testGetBillValid() {
	    
	    Receptionist receptionist = Receptionist.getInstance("Mahmood", "Aqaba", 8, "Receptionist Contact Number", "Receptionist");

	    Context context = new Context(new DentistStudent("Karam", "Irbid", 123456, "0798523697", 10.00));
	    context.executeStrategy();
	    Patient newPatient = (Patient) context.getStrategy();

	    receptionist.getPatientRecords().add(newPatient);

	    int calculatedBill = receptionist.getBill(newPatient.getNationalNumber());

	    Assertions.assertEquals(15, calculatedBill);
	}

    @Test
    public void testGetBillInvalid1() {
        
        Receptionist receptionist = Receptionist.getInstance("Mahmood", "Aqaba", 8, "Receptionist Contact Number", "Receptionist");
        int calculatedBill = receptionist.getBill(999999999);

        Assertions.assertEquals(0, calculatedBill);
    }

    @Test
    public void testGetBillInvalid2() {
        
        Receptionist receptionist = Receptionist.getInstance("Mahmood", "Aqaba", 8, "Receptionist Contact Number", "Receptionist");
        int calculatedBill = receptionist.getBill(-123);

        Assertions.assertEquals(0, calculatedBill);
    }
    
}
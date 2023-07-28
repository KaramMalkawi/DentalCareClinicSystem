package dentalCareClinicSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrdinaryPatientTest {

    @Test
    public void testCalculateBill1() {

    	OrdinaryPatient ordinaryPatient = new OrdinaryPatient("Karam", "Irbid", 123456, "12345", 10.00);
    	    	
    	Assertions.assertEquals(30, ordinaryPatient.calculateBill());
    }
    
    @Test
    public void testCalculateBill2() {

    	OrdinaryPatient ordinaryPatient = new OrdinaryPatient("Mazen", "Amman", 789465, "78956", 10.00);
    	
    	ordinaryPatient.setDiscount(-10);
    	
    	Assertions.assertNotEquals(30, ordinaryPatient.calculateBill());
    }
    
    @Test
    public void testCalculateBill3() {

    	OrdinaryPatient ordinaryPatient = new OrdinaryPatient("Mazen", "Amman", 789465, "78956", 10.00);
    	
    	ordinaryPatient.setDiscount(120);
    	    	
    	Assertions.assertNotEquals(30, ordinaryPatient.calculateBill());
    }

}

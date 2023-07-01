package dentalCareClinicSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DentistStudentTest {

    @Test
    public void testCalculateBill1() {

    	DentistStudent dentistStudent = new DentistStudent("Karam", "Irbid", 123456, "12345", 10.00);
    	    	
    	Assertions.assertEquals(15, dentistStudent.calculateBill());
    }
    
    @Test
    public void testCalculateBillInvalid1() {

    	OrdinaryPatient ordinaryPatient = new OrdinaryPatient("Mazen", "Amman", 789465, "78956", 10.00);
    	
    	ordinaryPatient.setDiscount(-10);
    	
    	Assertions.assertNotEquals(15, ordinaryPatient.calculateBill());
    }
    
    @Test
    public void testCalculateBillInvalid2() {

    	OrdinaryPatient ordinaryPatient = new OrdinaryPatient("Mazen", "Amman", 789465, "78956", 10.00);
    	
    	ordinaryPatient.setDiscount(120);
    	    	
    	Assertions.assertNotEquals(15, ordinaryPatient.calculateBill());
    }

}

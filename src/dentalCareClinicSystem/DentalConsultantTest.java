package dentalCareClinicSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DentalConsultantTest {

    @Test
    public void testCalculateBill1() {

    	DentalConsultant dentalConsultant = new DentalConsultant("Karam", "Irbid", 123456, "12345", 10.00);
    	    	
    	Assertions.assertEquals(24, dentalConsultant.calculateBill());
    }
    
    @Test
    public void testCalculateBill2() {

    	DentalConsultant dentalConsultant = new DentalConsultant("Mazen", "Amman", 789465, "78956", 10.00);
    	
    	dentalConsultant.setDiscount(-10);
    	
    	Assertions.assertNotEquals(24, dentalConsultant.calculateBill());
    }
    
    @Test
    public void testCalculateBill3() {

    	DentalConsultant dentalConsultant = new DentalConsultant("Mazen", "Amman", 789465, "78956", 10.00);
    	
    	dentalConsultant.setDiscount(120);
    	    	
    	Assertions.assertNotEquals(24, dentalConsultant.calculateBill());
    }

}

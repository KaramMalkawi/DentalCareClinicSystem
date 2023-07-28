package dentalCareClinicSystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ReceptionistTest.class,
	Nurse.class,
	DentistStudent.class, 
	OrdinaryPatientTest.class, 
	DentalConsultantTest.class
})

public class AllTests {

}

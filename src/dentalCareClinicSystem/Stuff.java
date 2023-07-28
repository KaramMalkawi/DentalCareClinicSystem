package dentalCareClinicSystem;

public class Stuff extends Parson{
	
	private String jobDescription;

	public Stuff(String name, String address, int nationalNumber, String phoneNumber, String jobDescription) {
	    super(name, address, nationalNumber, phoneNumber, nationalNumber);
	    this.jobDescription = jobDescription;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
    
}

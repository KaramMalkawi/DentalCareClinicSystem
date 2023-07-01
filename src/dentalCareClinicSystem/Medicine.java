package dentalCareClinicSystem;

public class Medicine {

	private String name;
	private int dose;
	
	public Medicine(String name, int dose) {
		this.name = name;
		this.dose = dose;
	}

	public Medicine() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}
	
	@Override
	public String toString() {
		return "Medicine name: " + name + "\nMedicine dose: " + dose;
	}
	
}

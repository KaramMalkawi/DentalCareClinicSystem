package dentalCareClinicSystem;

public class Context {

	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public int executeStrategy() {
		return strategy.calculateBill();
	}

	public Strategy getStrategy() {
		// TODO Auto-generated method stub
        return this.strategy;
	}
	
}

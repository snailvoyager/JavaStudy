package basic.abstractclass;

public class ManualCar extends Car{

	@Override
	public void drive() {
		System.out.println("Manual Drive...");
		
	}
	
	@Override
	public void stop() {
		System.out.println("Manual Stop...");
		
	}
}

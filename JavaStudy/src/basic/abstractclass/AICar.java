package basic.abstractclass;

public class AICar extends Car{

	@Override
	public void drive() {
		System.out.println("AI Drive...");
		
	}
	
	@Override
	public void stop() {
		System.out.println("AI Stop...");
		
	}
}

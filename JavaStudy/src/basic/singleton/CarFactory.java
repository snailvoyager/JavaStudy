package basic.singleton;

public class CarFactory {
	private static CarFactory factory = new CarFactory();
	
	private static int carNum = 10001;
	
	private CarFactory() {
		
	}
	
	public static CarFactory getInstance() {
		return factory;
	}
	
	public static Car createCar() {
		return new Car(carNum++);
	}
}

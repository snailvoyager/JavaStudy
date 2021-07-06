package basic.singleton;

public class CarFactoryTest {
	
	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();		//유일한 공장
		
		Car sonata = factory.createCar();
		Car avantte = factory.createCar();
		
		System.out.println(sonata.carNum);
		System.out.println(avantte.carNum);
	}

}

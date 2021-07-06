package basic.abstractclass;

public abstract class Car {
	public abstract void drive();
	public abstract void stop();
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	//final 메소드는 하위 객체에서 재정의 불가		
	final public void run() {		// Template Method. 정해진 시나리오
		startCar();
		drive();
		stop();
		turnOff();
	}

}

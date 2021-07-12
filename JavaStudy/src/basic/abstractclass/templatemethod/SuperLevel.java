package basic.abstractclass.templatemethod;

public class SuperLevel extends PlayerLevel{

	@Override
	void run() {
		System.out.println("most fastly run.");
	}
	
	@Override
	void jump() {
		System.out.println("most highly jump.");
	}
	
	@Override
	void turn() {
		System.out.println("Do turn.");
	}
	
	@Override
	void showLevelMessage() {
		System.out.println("Super Level...");
	}
}

package basic.abstractclass.templatemethod;

public class BeginnerLevel extends PlayerLevel{

	@Override
	void run() {
		System.out.println("Slowly run.");
	}
	
	@Override
	void jump() {
		System.out.println("Do not jump.");
	}
	
	@Override
	void turn() {
		System.out.println("Do not turn.");
	}
	
	@Override
	void showLevelMessage() {
		System.out.println("Beginner Level...");
	}
}

package basic.abstractclass.templatemethod;

public class AdvancedLevel extends PlayerLevel{

	@Override
	void run() {
		System.out.println("Fastly run.");
	}
	
	@Override
	void jump() {
		System.out.println("Highly jump.");
	}
	
	@Override
	void turn() {
		System.out.println("Do not turn.");
	}
	
	@Override
	void showLevelMessage() {
		System.out.println("Advanced Level...");
	}
}

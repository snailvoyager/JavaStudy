package basic.abstractclass.templatemethod;

public abstract class PlayerLevel {

	abstract void run();
	
	abstract void jump();
	
	abstract void turn();
	
	abstract void showLevelMessage();
	
	final public void go(int count) {
		showLevelMessage();
		run();
		
		for(int i=0; i<count; i++)
			jump();
		
		turn();
	}
}

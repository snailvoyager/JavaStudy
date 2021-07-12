package basic.abstractclass.templatemethod;

public class Player {

	PlayerLevel level;
	
	Player(PlayerLevel level) {
		this.level = level;
	}
	
	public PlayerLevel getLevel() {
		return this.level;
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
	}
	
	public void play(int count) {
		this.level.go(count);
	}
}

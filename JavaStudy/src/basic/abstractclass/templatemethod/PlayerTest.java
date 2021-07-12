package basic.abstractclass.templatemethod;

public class PlayerTest {

	public static void main(String[] args) {
		BeginnerLevel level1 = new BeginnerLevel();
		Player player1 = new Player(level1);
		player1.play(0);
		
		AdvancedLevel level2 = new AdvancedLevel();
		player1.upgradeLevel(level2);
		player1.play(2);
		
		SuperLevel level3 = new SuperLevel();
		player1.upgradeLevel(level3);
		player1.play(3);
	}

}

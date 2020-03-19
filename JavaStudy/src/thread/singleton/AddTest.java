package thread.singleton;

public class AddTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.genInstance();
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		
		for(int i: array) {
			new Thread(() ->{
				System.out.println(singleton.add());
			}).start();
		}
	}

}

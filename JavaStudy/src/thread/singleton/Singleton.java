package thread.singleton;

public class Singleton {
	int num;		//공유 자원
	
	private static Singleton singleton = new Singleton();
	
	private Singleton() {}
	
	public static Singleton genInstance() {
		return singleton;
	}
	
	public int add() {
		return ++num;	//공유 자원을 변경하면 Not Thread Safe
	}
	
	public int add2(int num) {	//파라미터로 데이터를 받아와서 리턴. Thread Safe
		return ++num;
	}
}

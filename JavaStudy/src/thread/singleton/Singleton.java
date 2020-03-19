package thread.singleton;

public class Singleton {
	int num;		//���� �ڿ�
	
	private static Singleton singleton = new Singleton();
	
	private Singleton() {}
	
	public static Singleton genInstance() {
		return singleton;
	}
	
	public int add() {
		return ++num;	//���� �ڿ��� �����ϸ� Not Thread Safe
	}
	
	public int add2(int num) {	//�Ķ���ͷ� �����͸� �޾ƿͼ� ����. Thread Safe
		return ++num;
	}
}

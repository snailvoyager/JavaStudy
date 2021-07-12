package basic.composition;

public interface InterfaceMethod {
	void abc();		//abstract method
	
	default void defaultMethod() {		//default method 구현하는 클래스에서 공통으로 사용
		System.out.println("Default Method");
	}
	
	static int staticMethod(int a, int b) {		//static method  인스턴스 생성없이 인터페이스 타입으로 사용
		return a + b;
	}
	
	//private void privateMethod() {}		//private method Java9...인터페이스 내부에서만 사용
	
	public static void main(String[] args) {
		System.out.println(InterfaceMethod.staticMethod(1, 2));
	}
}

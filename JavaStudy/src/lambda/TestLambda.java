package lambda;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		//자료형에 기반하여 선언
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("test lambda");
		
		//매개변수 전달
		showMyString(lambdaStr);
		
		//메서드 반환값으로 사용
		PrintString rtrn = returnString();
		rtrn.showString("Test3");
	}
	
	public static void showMyString(PrintString p) {
		p.showString("Test2");
	}
	
	public static PrintString returnString() {
		return s->System.out.println(s + "!!!");
	}

}

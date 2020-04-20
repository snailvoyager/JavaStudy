package basic;
import java.util.Arrays;

public class CallByReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		func(arr);
		System.out.println("main : "+ arr + Arrays.toString(arr));
		
		arr = func2(arr);		//새로 생성된 배열이 리턴
		System.out.println("main : "+ arr + Arrays.toString(arr));
	}
	
	public static void func(int[] arr) {		//배열의 주소값이 넘어감
		arr[0] = 5;								//main에서 넘어온 배열을 변경
		System.out.println("func : "+ arr + Arrays.toString(arr));
	}
	
	public static int[] func2(int[] arr) {
		arr = new int[3];		//새로운 배열 생성
		arr[0] = 10;
		System.out.println("func2 : "+ arr + Arrays.toString(arr));
		return arr;
	}

}

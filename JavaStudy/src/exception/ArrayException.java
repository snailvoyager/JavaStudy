package exception;

public class ArrayException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int [5];
		
		try {
			for(int i=0; i<=5; i++) {
				System.out.println(arr[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			
		}
		System.out.println("exit");
		
	}

}

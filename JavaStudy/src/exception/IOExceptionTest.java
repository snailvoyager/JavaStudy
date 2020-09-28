package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis = null;
		
		try(FileInputStream fis = new FileInputStream("a.txt")) {
			//fis = new FileInputStream("a.txt");
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} /*finally {
			try {
				fis.close();
				System.out.println("finally");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/ catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		System.out.println("end");
	}

}

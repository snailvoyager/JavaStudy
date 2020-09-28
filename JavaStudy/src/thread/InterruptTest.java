package thread;

public class InterruptTest extends Thread {
	
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(i);
		}
		
		try {
			sleep(5000);
			
		} catch(InterruptedException e) {
			System.out.println(e);
			System.out.println("Wake");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterruptTest test = new InterruptTest();
		test.start();
		test.interrupt();		//스레드 종료 후 인터럽트 실행되어 메인스레드 실행
		
		System.out.println("end");
	}

}

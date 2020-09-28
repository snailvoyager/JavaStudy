package thread;

import java.io.IOException;

public class TerminateThread extends Thread{
	
	private boolean flag = false;
	int i;
	
	public TerminateThread(String name) {
		super(name);
	}
	
	public void run() {
		while(!flag) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " end");
	}
	
	public void setFlag(boolean flag) {		//flag 값으로 스레드를 종료
		this.flag = flag;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TerminateThread thA = new TerminateThread("A");
		TerminateThread thB = new TerminateThread("B");
		
		thA.start();
		thB.start();
		
		int in;
		while(true) {
			in = System.in.read();
			if(in == 'A') {
				thA.setFlag(true);
			} else if(in == 'B') {
				thB.setFlag(true);
			} else if(in == 'M') {
				thA.setFlag(true);
				thB.setFlag(true);
				break;
			} else {
				System.out.println("try agagin");
			}
		}
		System.out.println("main end");
	}

}

package thread.multi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MethodTimeout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService thread = Executors.newSingleThreadExecutor();	//쓰레드 생성
		
		FutureTask<Object> task = new FutureTask<Object>(		//task 생성
				new Callable<Object>(){
					public Boolean call() throws Exception{
						work();				//로직 호출
						return true;
					}
				});
		
		thread.execute(task);	//task 실행
		
		try {
			task.get(3000, TimeUnit.MILLISECONDS);	//타임 아웃
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			thread.shutdownNow();	//쓰레드 제거
		}
	}
	
	public static void work() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("call work()...");
	}

}

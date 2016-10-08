package Threads_Runnables_Executors;
public class execRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++){
			System.out.println("Executor task running " + "ID " + Thread.currentThread().getId() + " values " + i);
			//pause execution of thread for 1000 milliseconds to print slower to the console
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}System.out.println("Task ID " + Thread.currentThread().getId() + " Completed");
		
	}

}

package Threads_Runnables_Executors;
//Create class and extend the thread class
public class myThread extends Thread{
	
	//overriding method of the thread class that runs the logic that I want a thread to do.
	@Override
	public void run() {
		//Loops 10 times and prints the value of i
		for (int i = 0; i < 10; i++){
			System.out.println("Extends thread " + Thread.currentThread().getId() + " values " + i);
			
			//Nasty Path: will not work without surrounding the method in a try catch block
			/*Thread.sleep(1000);*/
			
			//Happy Path
			//pauses thread for 1000 milliseconds within the loop to print results out slower
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	//a constructor of the class that prints out a statement of information
	public myThread(){
		System.out.println("Starting thread extended from the thread class");
	}
	
	
	
	
}

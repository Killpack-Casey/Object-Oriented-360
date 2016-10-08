package Threads_Runnables_Executors;
//class that implements the runnable interface
public class myRunnable implements Runnable {
	
	//overriding method
	@Override
	public void run() {
		for (int i = 0; i < 10; i++){
			System.out.println("Implement Runnable interface " + Thread.currentThread().getId() + " values " + change(i));
			//pause execution of thread for 1000 milliseconds to print slower to the console
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Run synchronized method examples
		try{
		//Nasty Path
		sMethod();
		
		//Happy Path
		syncMethod();
		
		}
		catch(Exception e){
			System.out.println("ERRRRORRR");
		}
	}
	
	//Happy Path: Actually recommended to not synchronize the whole method due to performance problems. It's better to write synchronized blocks within a method
	synchronized static void syncMethod(){
		for (int i = 0; i < 10; i++){
			System.out.println("Sync Implement Runnable interface " + Thread.currentThread().getId() + " values " + change(i));
			//pause execution of thread 1000 milliseconds
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Happiest Path: Like mentioned above it would be better to not make the method synchronized instead create this synchronized block within to do synchronization
			/*synchronized (myRunnable.class){
				
			}*/
		}
	}
	
	//Nasty Path: Won't synchronize: This method is not static, non static methods require object level lock not class level lock. Without the method being static the threads
	//will run the method simultaneously and not in sync
	synchronized void sMethod(){
		for (int i = 0; i < 10; i++){
			System.out.println("Not in Sync Implement Runnable interface " + Thread.currentThread().getId() + " values " + change(i));
			//pause thread for 1000 milliseconds
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//method that changes the values that are printed out from the loop
	public static int change(int i){
		if (i == 1){
			i = 500;
		}else{
			
		}
		if (i == 2){
			i = -5;
		}else{
			
		}
		return i;
	}


	// Nasty Path: Constructors can not be declared synchronized
	/*public synchronized myRunnable(){
	 
	 }
	 */
	
	//Happy Path: to do synchronization within a constructor you need to implement a synchronized block within it
	/*public myRunnable(){
		synchronized (this)
        {
            //synchronized block inside a constructor
        }
	}
	*/
	
// constructor that prints out the following information
	public myRunnable(){
		System.out.println("Starting thread implemented from the runnable interface");
		
	}

}
//---------------------NOTE--------------------------//
// thread won't let a class extend any other classes so use runnable it allows you to extend other classes if needed






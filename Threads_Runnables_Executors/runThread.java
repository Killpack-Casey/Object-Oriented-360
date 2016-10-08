package Threads_Runnables_Executors;
//class that runs the myThread and myRunnable classes
public class runThread {

	public static void main(String[] args) {
		
// -----------------------------------------------------------------
		//Extend Thread Class example (myThread class)
		
		//create object of the myThread class
				//Nasty Path: best to be implemented with implementing the runnable class because it is a subset of the thread class
				//myThread mt = new myThread();
				
				//create a thread of the mt object
				/*Nasty Path: because we created an object of a class that already extends the thread class it can mess us up as the constructor of the class prints
				out twice */
				//Thread t = new Thread(mt);
				
				//Happy path: Do not need to create an object when extending the thread class. The thread can just be created
				Thread extThread = new myThread();
				
				//create another thread
				Thread ex = new myThread();
				
				// ---------------NOTE------------------ //
				/* It is recommended that when creating threads that you implement the runnable interface because it allows you to extend another class. If you create
				 * threads by extending the thread class you can no longer extend other classes.
				 */
				
				//Nasty Path: See above comments, the constructor prints out twice t.start() is an object of a class that already extends the thread class
				//t.start();
				
				//Happy path: starts the thread by calling the run() method
				extThread.start();
				ex.start();
				
				//Nasty path: by calling the run method a new thread will not be created the execution will be ran in the same execution block as the main method
				//extThread.run();
	
// ------------------------------------------------------------------------------------------------------------------------------
			// Implement Runnable Interface example (myRunnable class)
	
			//Nasty Path: Does not work because myRunnable does not extend the thread class to create threads.
			//Thread th = new myRunnable();
				
				// Pauses the execution of the following threads so the first two can complete before starting my next two examples of threads implemented by the runnable interface
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			//create two objects of the myRunnable class
			//Happy Path
			myRunnable mr = new myRunnable();
			myRunnable mru = new myRunnable();
			
			//create a thread of the mr and mru object
			//Happy Path
			Thread t = new Thread(mr);
			Thread r = new Thread(mru);
			
			//run the two threads
			t.start();
			r.start();
			
		//----------------NOTES------------------//	
		/* thread1.run();
		*  Being ran in current thread does not create a new one to start running thread, must execute before the next line of code
		*/
			
			/* does create a thread creates the run method on a new thread, the two .start threads run in parallel so ordering is not consistent
			*  thread2.start();
			*  creates another thread thread 2 and 3 run at same time does not wait to finish thread 2 until running thread 3
			*  thread3.start();
			*/
			

			/* Thread Synchronization
			*  Synchronization allows a thread to run a method and complete before the other thread executes the method, it prevents thread interference
			*/		

	}

}

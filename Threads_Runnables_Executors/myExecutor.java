package Threads_Runnables_Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// Executors are the preferred way to running tasks
// Threads from a thread pool are recycled and reused instead of creating a thread from the thread class every time to start one
// You have to call its shutdown method when done with the executor service
// The shutdown wont stop tasks that are pending or in the queue, it will finish them before shutting down
// shutdown now method will stop all pending and in queue tasks

public class myExecutor {

	public static void main(String[] args) {
		
		//creates an executor service that schedules execution of the task passed to it
		//ExecutorService ex = Executors.newScheduledThreadPool(10);
		
		//fixed thread pool executor service
		//creates a fixed number of threads and a task is executed by
		// one of these threads
		//All tasks execute in different threads at same time
		//If you execute more than the amount of threads you specified the task waits for one to end and the one more you have in queue
		// starts
		//Initializes the executor service
		ExecutorService fixService = Executors.newFixedThreadPool(4);
		
		//submit task to the service
		fixService.execute(new execRunnable());
		fixService.execute(new execRunnable());
		fixService.execute(new execRunnable());
		fixService.execute(new execRunnable());
		
		//if you don't shutdown your executor service it will create a memory leak in your application
		fixService.shutdown();
		
		//nasty path: Because there are other tasks in the queue running
		//Shuts everything down and does not wait for any tasks running in queue to finish
		//fixService.shutdownNow();
		
		//cached thread pool
		//number of threads not fixed if there is a thread not available another thread is created, there is no limit.
		//NO task has to wait for execution there is no queue
		//Threads are reused as well
		ExecutorService cacheService = Executors.newCachedThreadPool();
		
		cacheService.execute(new execRunnable());
		cacheService.execute(new execRunnable());
		cacheService.execute(new execRunnable());
		cacheService.execute(new execRunnable());
		cacheService.execute(new execRunnable());
		
		cacheService.shutdown();
		
		//single thread executor has a set pool side of one
		//one task is executed at a time, one by one in sequence only
		//removes the need for synchronization
		ExecutorService singleService = Executors.newSingleThreadExecutor();
		
		singleService.execute(new execRunnable());
		singleService.execute(new execRunnable());
		singleService.execute(new execRunnable());
		
		singleService.shutdown();
	
		
		
		/*//executer service 
		executor.execute(new Runnable(){
			public void run() {
				System.out.println("Asynchronous task");
			}
		});
		
		executor.shutdown();

	}*/
	
	//void execute(Runnable Task);

}}

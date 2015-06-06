import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SharedArrayTest 
{

	public static void main(String[] args) 
	{
		SimpleArray shared = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1, shared);
		ArrayWriter writer2 = new ArrayWriter(11, shared);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		
		executor.shutdown();
		
		try
		{
			boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
			
			if (tasksEnded)
				System.out.println (shared);
			else
				System.out.println("Timed out while waiting for tasks to finish");
		}
		catch (InterruptedException e)
		{
			System.out.println ("Interrupted while waiting for tasks to finish");
		}
	}

}

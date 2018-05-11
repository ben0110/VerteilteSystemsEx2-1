import java.util.concurrent.LinkedBlockingQueue;

public class messageSequencer implements Runnable{
	private LinkedBlockingQueue queue;
	private LinkedBlockingQueue[] threadsQueue; 
	
	public messageSequencer(LinkedBlockingQueue queue,LinkedBlockingQueue[] queueArray)
	{
		this.queue=queue;
		this.threadsQueue=queueArray;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

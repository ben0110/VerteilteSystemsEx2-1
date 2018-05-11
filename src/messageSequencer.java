import java.util.concurrent.LinkedBlockingQueue;

public class messageSequencer implements Runnable{
	private LinkedBlockingQueue sequencerQueue;
	private LinkedBlockingQueue[] threadsQueue; 
	
	public messageSequencer(LinkedBlockingQueue queue,LinkedBlockingQueue[] queueArray)
	{
		this.sequencerQueue=queue;
		this.threadsQueue=queueArray;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			internalMessage IM = (internalMessage) sequencerQueue.take();
			for (int i=0; i< threadsQueue.length;i++)
			{
				threadsQueue[i].add(IM);
			}
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

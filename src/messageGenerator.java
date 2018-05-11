import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
public class messageGenerator implements Runnable{

	private LinkedBlockingQueue[] threadsQueue;
	private int maxGenExtMsgs;
	
	public messageGenerator(LinkedBlockingQueue[] threadsQueue,int maxGenExtMsgs) {
		this.threadsQueue = threadsQueue;
		this.maxGenExtMsgs = maxGenExtMsgs;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<maxGenExtMsgs;i++)
		{
			int randomNum = ThreadLocalRandom.current().nextInt(0, threadsQueue.length);
			externalMessage Em = new externalMessage(i);
			try {
				threadsQueue[randomNum].put(Em);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


}

import java.util.concurrent.LinkedBlockingQueue;

public class Client implements Runnable {
	
	LinkedBlockingQueue threadQueue;
	LinkedBlockingQueue sequencerQueue;
	
	public Client(LinkedBlockingQueue threadQueue,LinkedBlockingQueue sequencerQueue) {
		this.threadQueue= threadQueue;
		this.sequencerQueue = sequencerQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

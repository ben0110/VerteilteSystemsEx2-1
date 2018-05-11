import java.util.concurrent.LinkedBlockingQueue;

public class Client implements Runnable {
	
	LinkedBlockingQueue threadQueue;
	LinkedBlockingQueue sequencerQueue;
	int ClientNbr;
	int[] IntMsgReceived; 
	int Msgs=0;
	public Client(LinkedBlockingQueue threadQueue,LinkedBlockingQueue sequencerQueue,int ClientNbr,int maxNbrMsg) {
		this.threadQueue= threadQueue;
		this.sequencerQueue = sequencerQueue;
		this.ClientNbr = ClientNbr;
		IntMsgReceived = new int[maxNbrMsg];
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(!threadQueue.isEmpty())
			{
				Object M= threadQueue.take();
			
				if(M instanceof externalMessage)
				{
					internalMessage IM = new internalMessage(ClientNbr,((externalMessage) M).MsgNbr);
					sequencerQueue.add(IM);
				
				}
				else if (M instanceof internalMessage)
				{
					IntMsgReceived[Msgs]= ((internalMessage) M).msgNbr;
					Msgs++;
				
				}
				
			}	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

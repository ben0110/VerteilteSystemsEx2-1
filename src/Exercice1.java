import java.util.concurrent.LinkedBlockingQueue;

public class Exercice1 {
	public static void main(int[] args)
	{
		int maxGenExtMsgs = args[1];
		int nbrClients = args[0];
		
		LinkedBlockingQueue[] threadQueueArray = new LinkedBlockingQueue[nbrClients];
		for(int i=0 ; i<threadQueueArray.length;i++)
			threadQueueArray[i]= new LinkedBlockingQueue();
			
		LinkedBlockingQueue SequencerQueue = new LinkedBlockingQueue();
		
		
		messageGenerator Generator = new messageGenerator(threadQueueArray,maxGenExtMsgs) ;
		messageSequencer Sequencer = new messageSequencer(SequencerQueue,threadQueueArray);
		
		Client[] Clients = new Client[nbrClients];
		for(int i=0; i<Clients.length;i++)
			Clients[i]= new Client(threadQueueArray[i],SequencerQueue);
		
	}

}

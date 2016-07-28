package hw4;

import hw3.*;

public class QThread implements Runnable{
	public customerQueue cashierQ;
	int t = 0;
	
	Thread thread;
	String threadName;
	Manager manager;
	
	String outputString;
	
	QThread (String name, Manager man) {
		//Reference to manager
		threadName = name;
		manager = man;
		System.out.println("Thread " + threadName + " created.");
	}
	
	@Override
	public void run() {
		//Time keeping / Thread Loop
		for(;;){
			if(t < 50){
				//WAIT
				t++;
				try {
					Thread.sleep(NumberRandom(45, 155));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}else{
				//UPDATE PROGRESS
				cashierQ.RemoveAt(0);
				if(NumberRandom(0, 10)<5){
					manager.OptimizeQueues();
				}
				t = 0;
				System.out.println(threadName + " progressed.");
				manager.UpdateOutput();
			}
		}
		
	}
	
	public int NumberRandom(int min, int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
	
	public void start (){
		//Starts Thread
		System.out.println("Starting " +  threadName );
		cashierQ = new Queue("cashier");
		//Add Initial 5 Customers per Queue
		for(int i=0;i<NumberRandom(7, 10);i++){
			cashierQ.AddToQueue("SomeDude");
		}
		if (thread == null){
			thread = new Thread (this, threadName);
			thread.start ();
		}
	}
	
	public String ToString(){
		//Function to generate UI Output String
		outputString = new String();
		outputString += "\u26e9 " + threadName + " \u26e9 \n";
		for(int i=0; i<cashierQ.GetLength(); i++){
			outputString += "    \u265f";
		}
		outputString += "\n \n";
		//Returns string to be printed by manager
		return outputString;
	}
}

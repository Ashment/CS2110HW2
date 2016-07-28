package hw4;

import hw3.*;

public class FeederThread implements Runnable{

	Manager manager;
	
	int t;
	
	String threadName;
	Thread thread;
	
	public FeederThread(Manager man, String name){
		//Reference to Main
		manager = man;
		threadName = name;
	}
		
	public void start (){
		//Starts Thread
		System.out.println("Starting " +  threadName );
		if (thread == null){
			thread = new Thread (this, threadName);
			thread.start ();
		}
	}
	
	@Override
	public void run() {
		//Time Keeping / Thread Loop
		for(;;){
			if(t < 20){
				//WAIT
				t++;
				try {
					Thread.sleep(NumberRandom(15, 25));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}else{
				//Behavior
				manager.cashiers[NumberRandom(0, 9)].cashierQ.AddToQueue("SomeDude");
				manager.OptimizeQueues();
				manager.UpdateOutput();
				t = 0;
				System.out.println("Customer Added.");
			}
		}
	}
	
	public int NumberRandom(int min, int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}

}

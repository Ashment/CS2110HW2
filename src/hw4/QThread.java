package hw4;

import hw3.*;
import hw2.RandomNumbers;

public class QThread implements Runnable{
	Queue cashierQ;
	int t = 0;
	
	Thread thread;
	String threadName;
	Manager manager;
	
	RandomNumbers rando;
	
	QThread (String name, Manager man) {
		threadName = name;
		manager = man;
		System.out.println("Thread " + threadName + " created.");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			if(t < 100){
				//WAIT
				t++;
				try {
					Thread.sleep(NumberRandom(80, 120));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}else{
				//UPDATE PROGRESS
				cashierQ.RemoveAt(0);
				manager.OptimizeQueues();
				t = 0;
				System.out.println(threadName + " progressed.");
			}
		}
		
	}
	
	public int NumberRandom(int min, int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
	
	public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      cashierQ = new Queue("cashier");
	      if (thread == null)
	      {
	         thread = new Thread (this, threadName);
	         thread.start ();
	      }
	   }
	
}

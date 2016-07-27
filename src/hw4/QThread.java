package hw4;

import hw3.*;

public class QThread implements Runnable{
	Queue CashierQ;
	int t = 0;
	
	Thread thread;
	String threadName;
	
	
	QThread (String name) {
		threadName = name;
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
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}else{
				//UPDATE PROGRESS
				t = 0;
			}
		}
		
	}
	
	public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      CashierQ = new Queue("cashier");
	      if (thread == null)
	      {
	         thread = new Thread (this, threadName);
	         thread.start ();
	      }
	   }
	
}

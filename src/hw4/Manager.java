package hw4;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hw3.*;

public class Manager {
	QThread[] cashiers = new QThread[10];
	QThread shortestQ;
	Manager managerThis;
	
	public Manager(){
		managerThis = this;
		//Initialize queue and have reference to interface
		for(int i=0; i<cashiers.length; i++){
			cashiers[i] = new QThread("Cashier No." + i, managerThis);
			cashiers[i].run();
			System.out.print("Cashier " + i + " now running!");
		}
		shortestQ = cashiers[0];
	}
	
	public void OptimizeQueues(){
		Customer tempC;
		for(int i=0; i<cashiers.length; i++){
			if(cashiers[i].cashierQ.GetLength() < shortestQ.cashierQ.GetLength()){
				shortestQ = cashiers[i];
			}
		}
		for(int i=0; i<cashiers.length; i++){
			if(cashiers[i].cashierQ.GetLength() > shortestQ.cashierQ.GetLength() + 1){
				tempC = cashiers[i].cashierQ.GetCustomerAt(shortestQ.cashierQ.GetLength() + 2);
				cashiers[i].cashierQ.RemoveAt(shortestQ.cashierQ.GetLength() + 2);
				shortestQ.cashierQ.AddToQueue(tempC);
			}
		}
	}
	
	public void UpdateOutput(){
		
	}
}

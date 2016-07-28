package hw4;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import hw3.*;

public class Manager {
	QThread[] cashiers = new QThread[10];
	QThread shortestQ;
	Manager managerThis;
	FeederThread feeder;
	
	JFrame mainFrame;
	JTextArea textArea;
	
	boolean isBusy = false;
	
	public static void main(String[] args) throws Exception{
		new Manager();
	}
	
	public Manager(){
		managerThis = this;
		//Initialize queue and have reference to interface
		for(int i=0; i<cashiers.length; i++){
			cashiers[i] = new QThread("Cashier No." + (i+1), managerThis);
			cashiers[i].start();
			System.out.println("Cashier " + (i+1) + " now running!");
		}
		//Set up feeder thread
		feeder = new FeederThread(managerThis, "FeederThread");
		feeder.start();
		System.out.println("Feeder Now Running.");
		
		shortestQ = cashiers[0];
			
		//Set up the Interface
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame = new JFrame("Title");
				mainFrame.setSize(850, 610);
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.setLocationRelativeTo(null);
				mainFrame.setVisible(true);
				mainFrame.setResizable(false);
				
				textArea = new JTextArea(75, 50);
				textArea.setEditable(false);
				textArea.setFont(new Font("Serif",Font.PLAIN,20));
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setForeground(Color.WHITE);
				mainFrame.getContentPane().add(textArea);
			}
		});
		
		System.out.println("Initialized.");
	}
	
	public void OptimizeQueues(){
		Customer tempC;
		boolean hasOptimized = false;
			
		if(!isBusy){
			isBusy = true;
			//Decides which is shortest queue
			for(int i=0; i<cashiers.length; i++){
				if(cashiers[i].cashierQ.GetLength() < shortestQ.cashierQ.GetLength()){
					shortestQ = cashiers[i];
				}
			}
			
			//Moves to optimize queue lengths
			for(int i=0; i<cashiers.length; i++){
				//If there is big difference in queue, customer will seek more efficient queue
				if(cashiers[i].cashierQ.GetLength() > shortestQ.cashierQ.GetLength() + 4){
					tempC = cashiers[i].cashierQ.GetCustomerAt(cashiers[i].cashierQ.GetLength() - 1);
					cashiers[i].cashierQ.RemoveAt(cashiers[i].cashierQ.GetLength() - 1);
					shortestQ.cashierQ.AddToQueue(tempC);
					hasOptimized = true;
					System.out.println("Customer Moved From " + cashiers[i].threadName + " to " + shortestQ.threadName);
				}
			}
			
			if(hasOptimized){
				isBusy = false;
				//Chance to re-optimize after first optimization is successful
				if(cashiers[0].NumberRandom(0, 10) < 3){
					OptimizeQueues();
				}
			}else{
				isBusy = false;
			}
		}
	}
	
	public void UpdateOutput(){
		//Updates the printed stuff
		String outputString = new String();
		if(textArea != null){
			for(int i=0; i<cashiers.length; i++){
				outputString += (cashiers[i].ToString());
			}

			textArea.setText(outputString);
		}
		
	}
}

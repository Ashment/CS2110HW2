package hw4;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hw3.MainGUI;
import hw3.Queue;

public class Manager {
	QThread[] cashiers = new QThread[10];
	Manager managerThis;
	
	public Manager(){
		managerThis = this;
		//Initialize queue and have reference to interface
		for(int i=0; i<cashiers.length; i++){
			cashiers[i] = new QThread("Cashier No." + i);
			cashiers[i].run();
			System.out.print("Cashier " + i + " now running!");
		}
	}
}

package hw4;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hw3.MainGUI;
import hw3.Queue;

public class Manager {
	QThread[] cashiers = new QThread[10];
	Manager managerThis;
	
	public manager(){
		managerThis = this;
		//Initialize queue and have reference to interface
		for(int i=0; i<cashiers.length; i++){
			cashiers[i] = new QThread("Cashier No." + i);
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mainGUI = new MainGUI("Title", mainThis);
				mainGUI.setSize(750, 450);
				mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainGUI.setVisible(true);
			}
		});
}

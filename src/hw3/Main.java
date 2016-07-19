package hw3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static MainGUI mainGUI;
	public static Main mainThis;
	public static Queue q;
	public static customerQueue cQ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}
	
	public Main(){
		mainThis = this;
		//Initialize queue and have reference to interface
		q = new Queue("Default Queue");
		cQ = q;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mainGUI = new MainGUI("Title", mainThis);
				mainGUI.setSize(550, 450);
				mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainGUI.setVisible(true);
			}
		});
	}
	
	
	public String[] SortDefaultStrings(){
		//array of names of customers to return
		String[] temp = new String[cQ.GetLength()];
		
		//copy names from customers to temp
		for(int i=0; i<temp.length; i++){
			temp[i] = cQ.GetCustomerAt(i).name;
		}
		return temp;
	}
	
	public String[] SortAlphaStrings(){
		//array of names of customers to return
		String[] temp = new String[cQ.GetLength()];
		Customer[] alphaTemp = cQ.CustomerAlphabetical();
		
		//copy names from customers to temp
		for(int i=0; i<temp.length; i++){
			temp[i] = alphaTemp[i].name;
		}
		
		return temp;
	}
	
	public void NextCustomerString(){
		
	}
}

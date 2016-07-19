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
				mainGUI.setSize(750, 450);
				mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainGUI.setVisible(true);
			}
		});
	}
	
	public void NextCustomer(){
		//Remove the first customer, and move others up (this method can be used with any index i and would work the same way)
		cQ.RemoveAt(0);
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
	
	//Find customer result can be directly printed to output
	public String FindCustomer(String s){
		String returnString = "";
		
		//loop through and test match for names
		for(int i=0; i<cQ.GetLength(); i++){
			if(cQ.GetCustomerAt(i).name == s){
				returnString = s + " is #" + (i+1) + " in queue.";
				return returnString;
			}
		}
		
		returnString = "Customer not found in queue.";
		return returnString;
	}
	
	public void AnalyzeFile(String source){
		System.out.println("ANALYZE FILE");
		String[] inputArray;
		
		//Split received input string
		inputArray = source.split(" ");
		
		//Convert string array to double array
		for(int i=0; i<inputArray.length; i++){
			try{
				cQ.AddToQueue(inputArray[i]);
			} catch (Exception e){
				System.out.println(e);
				return;
			}
		}
	}
}

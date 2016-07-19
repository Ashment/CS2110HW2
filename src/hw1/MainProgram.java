package hw1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainProgram{
	public static MainProgram master;
	public String[] inputArray;
	public double[] convertedInputArray;
	public MainGUI mainGUI;
	
	double preRoot;

	public static void main (String[] args) throws Exception{
		master = new MainProgram();
		
		
	}
	
	//CONSTRUCTOR
	public MainProgram(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mainGUI = new MainGUI("Application Window", master);
				mainGUI.setSize(550, 350);
				mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainGUI.setVisible(true);
			}
		});
	}
	
	public void AnalyzeNumbers(String source){
		System.out.println("ANALYZE NUMBERS");
		
		//Split received input string
		String[] inputArray = source.split(" ");
		
		//Convert string array to double array
		convertedInputArray = new double[inputArray.length];
		for(int i=0; i<inputArray.length; i++){
			try{
			convertedInputArray[i] = Double.parseDouble(inputArray[i]);
			} catch (Exception e){
				System.out.println(e);
				mainGUI.outputPanel.outputArea.setText(e.toString());
				return;
			}
		}
		UpdateOutput(convertedInputArray);
	}
	
	public void AnalyzeFile(String source){
		System.out.println("ANALYZE FILE");
		
		//Split received input string
		inputArray = source.split(" ");
		
		//Convert string array to double array
		convertedInputArray = new double[inputArray.length];
		for(int i=0; i<inputArray.length; i++){
			try{
			convertedInputArray[i] = Double.parseDouble(inputArray[i]);
			} catch (Exception e){
				System.out.println(e);
				mainGUI.outputPanel.outputArea.setText(e.toString());
				return;
			}
		}
		UpdateOutput(convertedInputArray);
	}
	
	public void UpdateOutput(double[] convertedInputArray2){
		mainGUI.outputPanel.outputArea.setText("");
		mainGUI.outputPanel.outputArea.append("\n" + "Sum Total: " + GetTotal(convertedInputArray2) + "\n"
				+ "Minimum Value: " + GetMin(convertedInputArray2) + "	Maximum Value:" + GetMax(convertedInputArray2)  + "\n"
				+ "Range: " + (GetMax(convertedInputArray2) - GetMin(convertedInputArray2)) + "\n"
				+ "Mean: " + GetAvg(convertedInputArray2, GetTotal(convertedInputArray2)) + "\n"
				+ "Population Standard Deviation: " + GetStdDev(convertedInputArray2, GetTotal(convertedInputArray2), GetAvg(convertedInputArray2, GetTotal(convertedInputArray2))) + "\n"
				+ "Sample Standard Deviation: " + GetSampleStdDev(convertedInputArray2, GetTotal(convertedInputArray2), GetAvg(convertedInputArray2, GetTotal(convertedInputArray2))) + "\n");
	}
	
	//CALCULATION FUNCTIONS BELOW -----------------------------------------------------
	public double GetTotal(double[] inArray){
		double total = 0;
		for (int i=0; i<inArray.length; i++){
			total += inArray[i];
		}
		return total;
	}
	
	public double GetAvg(double[] inArray, double total){
		return(total / inArray.length);
	}
	
	public double GetStdDev(double[] inArray, double total, double Avg){
		preRoot = 0;
		double localPreRoot;
		
		for (int i=0; i<inArray.length; i++){
			inArray[i] = Math.pow((inArray[i] - Avg), 2);
			preRoot += inArray[i];
		}
		
		System.out.println(preRoot);
		localPreRoot = preRoot / inArray.length;
		return(Math.sqrt(localPreRoot));
	}
	
	public double GetSampleStdDev(double[] inArray, double total, double Avg){
		double localPreRoot;
		
		System.out.println(preRoot);
		localPreRoot = (preRoot) / (inArray.length - 1);
		return(Math.sqrt(localPreRoot));
	}
	
	public double GetMin(double[] inArray){
		double val = inArray[0];
		//Find Smallest Numbers
		for (int i=0; i<inArray.length; i++){
			if(inArray[i] <= val){
				val = inArray[i];
			}
		}
		return val;
	}
	public double GetMax(double[] inArray){
		double val = inArray[0];
		//Find Smallest Numbers
		for (int i=0; i<inArray.length; i++){
			if(inArray[i] >= val){
				val = inArray[i];
			}
		}
		return val;
	}
}

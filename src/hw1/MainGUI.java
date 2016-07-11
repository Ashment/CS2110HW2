package hw1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainGUI extends JFrame{

	MainProgram mainP;
	
	public InputPanel inputPanel;
	public ButtonPanel buttonPanel;
	public OutputPanel outputPanel;
	GridBagConstraints gc;
	Container c;
	
	public MainGUI(String title, MainProgram m){
		super(title);
		mainP = m;
		
		//Layout--------------------------------------------------------------
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		
		
		//Initialize Component Classes----------------------------------------
		inputPanel = new InputPanel(m);
		buttonPanel = new ButtonPanel(m);
		outputPanel = new OutputPanel(m);
		
		//Container Styling---------------------------------------------------
		c = getContentPane();
		c.setBackground(Color.DARK_GRAY);
		c.setForeground(Color.LIGHT_GRAY);
		
		//Add Components to Container-----------------------------------------
		gc.gridx=1; gc.gridy=0;
		c.add(inputPanel, gc);
		gc.gridx=1; gc.gridy=1;
		c.add(buttonPanel, gc);
		gc.gridx=1; gc.gridy=2;
		c.add(outputPanel, gc);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

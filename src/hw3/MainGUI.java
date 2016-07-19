package hw3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainGUI extends JFrame{
	
	JTextArea outputArea;
	JTextField inputField;
	JButton readButton;
	
	Main main;
	JPanel topPanel, botPanel;
	JButton defaultButton, alphaButton, nextButton;
	
	FileParser fileParser;
	
	String[] printTargetArray;
	
	MainGUI(String title, Main m){
		super(title);
		main = m;
		fileParser = new FileParser();
		
		//set layout
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		//Initialize input and output UI
		outputArea = new JTextArea(5, 5);
		outputArea.setLineWrap(true);
		//outputArea.setEditable(false);
		outputArea.setBackground(Color.BLACK);
		outputArea.setForeground(Color.WHITE);
		outputArea.setPreferredSize(new Dimension(500, 300));
		JScrollPane scrConsole = new JScrollPane(outputArea);
		scrConsole.setBackground(Color.BLACK);
		
		inputField = new JTextField(10);
		inputField.setForeground(Color.BLUE);
		
		//Initialize Button
		readButton = new JButton("Read File");
		readButton.setPreferredSize(new Dimension(80, 30));
		
		
		Container c = getContentPane();
		c.setBackground(Color.DARK_GRAY);
		initTopPanel();
		initBotPanel();
		c.add(topPanel, BorderLayout.NORTH);
		c.add(scrConsole, BorderLayout.CENTER);
		c.add(botPanel, BorderLayout.SOUTH);
	}
	
	void initTopPanel(){
		//PANEL
		topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.setPreferredSize(new Dimension(500, 40));
		
		//BORDER + Label
		Border windowBorder = BorderFactory.createLineBorder(Color.WHITE);
		topPanel.setBorder(windowBorder);
		JLabel inputLabel = new JLabel("Input File Name: ");
		inputLabel.setForeground(Color.WHITE);
		
		//Laying Out Panel
		topPanel.setLayout(new FlowLayout());
		topPanel.add(inputLabel);
		topPanel.add(inputField);
		topPanel.add(readButton);
	}
	
	void initBotPanel(){
		defaultButton = new JButton("Default");
		alphaButton = new JButton("Alphabetical");
		nextButton = new JButton("Next Customer");
		
		botPanel = new JPanel();
		botPanel.setBackground(Color.DARK_GRAY);
		botPanel.setPreferredSize(new Dimension(500, 40));
		
		//BORDER + Label
		Border windowBorder = BorderFactory.createLineBorder(Color.WHITE);
		botPanel.setBorder(windowBorder);
		JLabel sortLabel = new JLabel("Sort: ");
		sortLabel.setForeground(Color.WHITE);
		
		//Laying Out Panel
		botPanel.setLayout(new FlowLayout());
		botPanel.add(sortLabel);
		botPanel.add(defaultButton);
		botPanel.add(alphaButton);
		botPanel.add(nextButton);
	}
	
	public void UpdateInteractionBehavior(){
		//Behavior
		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					fileParser.parseFile(inputField.getText());
					
				} catch (Exception e1) {
					e1.printStackTrace();
					outputArea.append("\n File Not Found!");
				}
			}
		});
		defaultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				outputArea.append("\n Sorting by Queue Order... \n");
				UpdateOutputArea(main.SortDefaultStrings());
			}
		});
		alphaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				outputArea.append("\n Sorting by Alphabetical Order... \n");
				UpdateOutputArea(main.SortAlphaStrings());
			}
		});
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				main.NextCustomerString();
				outputArea.append("\n Queue has modified to reflect the first in queue having been served. \n");
			}
		});
	}
	
	public void UpdateOutputArea(String[] targetStrings){
		for (int i=0; i<targetStrings.length; i++){
			outputArea.append(targetStrings[i] + ", ");
		}
	}
}

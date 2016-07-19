package hw3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

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
	
	JPanel topPanel;
	
	MainGUI(String title){
		super(title);
		
		//set layout
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		//Initialize input and output UI
		outputArea = new JTextArea(16, 15);
		outputArea.setLineWrap(true);
		outputArea.setEditable(false);
		outputArea.setPreferredSize(new Dimension(550, 250));
		JScrollPane scrConsole = new JScrollPane(outputArea);
		scrConsole.setBackground(Color.BLACK);
		
		inputField = new JTextField(10);
		inputField.setForeground(Color.BLUE);
		
		//Initialize Button
		readButton = new JButton("Read File");
		readButton.setPreferredSize(new Dimension(80, 30));
		
		
		Container c = getContentPane();
		c.setBackground(Color.DARK_GRAY);
		initPanel();
		c.add(outputArea, BorderLayout.CENTER);
		c.add(topPanel, BorderLayout.NORTH);
	}
	
	void initPanel(){
		//PANEL
		topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.setPreferredSize(new Dimension(500, 50));
		
		//BORDER + Label
		Border windowBorder = BorderFactory.createLineBorder(Color.WHITE);
		topPanel.setBorder(windowBorder);
		JLabel inputLabel = new JLabel("Input File Name: ");
		inputLabel.setForeground(Color.WHITE);
		
		topPanel.setLayout(new FlowLayout());
		topPanel.add(inputLabel);
		topPanel.add(inputField);
		topPanel.add(readButton);
	}
}

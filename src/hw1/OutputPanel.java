package hw1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class OutputPanel extends JPanel {

	int width = 500, height = 182;
	JTextArea outputArea;
	JTextField filenameField;
	JButton saveButton;
	JLabel filenameLabel;
	MainProgram main;
	String dataSetString;
	
	public OutputPanel(MainProgram m){
		main = m;
		//Styling
		setBackground(Color.DARK_GRAY);
		setSize(width, height);
		setPreferredSize(new Dimension(width, height));
		
		TitledBorder titBorder = new TitledBorder("Analysis Output");
		titBorder.setTitleJustification(TitledBorder.CENTER);
		titBorder.setTitleColor(Color.WHITE);
		setBorder(titBorder);
		
		//Establish Layout and Components
		setLayout(new BorderLayout());
		outputArea = new JTextArea(8, 32);
		outputArea.setForeground(Color.WHITE);
		outputArea.setBackground(Color.DARK_GRAY);
		outputArea.setEditable(false);
		saveButton = new JButton("Save Output");
		filenameField = new JTextField(15);
		filenameField.setPreferredSize(new Dimension(300, 10));
		filenameField.setText("output.txt");
		filenameLabel = new JLabel(" File Name: ");
		filenameLabel.setForeground(Color.WHITE);
		
		//Add Components
		add(outputArea, BorderLayout.NORTH);
		add(filenameLabel, BorderLayout.WEST);
		add(filenameField, BorderLayout.CENTER);
		add(saveButton, BorderLayout.EAST);
		
		//Interact to save file
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dataSetString = "Data Set: ";
				PrintWriter writer;
				
				for (int i=0; i<main.inputArray.length; i++){
					if(i!=0){
						dataSetString += ", ";
					}
					dataSetString += main.inputArray[i];
				}
				
				
				try {
					//Write UTF-8 encoding output file to default root directory
					writer = new PrintWriter(filenameField.getText(), "UTF-8");
					writer.println(dataSetString);
					writer.println(outputArea.getText());
					writer.close();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					System.out.println(e1.toString());
				}
			}
		});
	}
}

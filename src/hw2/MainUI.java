package hw2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MainUI extends JFrame implements ActionListener{
	JTextArea outputArea;
	JButton cycleButton;
	public Main main;
	
	public MainUI(String title, Main m){
		super(title);
		main = m;
		
		//set layout
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		//Initialize Output Area to output text
		outputArea = new JTextArea(16, 15);
		outputArea.setLineWrap(true);
		outputArea.setEditable(false);
		JScrollPane scrConsole = new JScrollPane(outputArea);
		scrConsole.setBackground(Color.WHITE);
		//scrConsole.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		//Initialize Cycle Button
		cycleButton = new JButton("-Start New Cycle-");
		cycleButton.setActionCommand("cycle");
		cycleButton.addActionListener(this);
		
		Container c = getContentPane();
		c.setBackground(Color.DARK_GRAY);
		c.add(scrConsole, BorderLayout.NORTH);
		c.add(cycleButton, BorderLayout.SOUTH);
	}
	
	public void AddMessage(String message){
		outputArea.append(message);
	}

	public void actionPerformed(ActionEvent e) {
		if("cycle".equals(e.getActionCommand())){
			//System.out.println("cycle button pressed");
			//Call new cycle button from main
			main.StartNewCycle();
		}
	}
}

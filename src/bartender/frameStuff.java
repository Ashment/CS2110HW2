package bartender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frameStuff extends JFrame {
	
	JPanel customersPanel, testPanell;
	Container c;
	GridBagConstraints gc;
	
	public frameStuff(String title, Main d){
		super(title);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(new KeyInput(d));
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		
		customersPanel = new CustomersPanel();
		
		c = getContentPane();
		
		gc.gridx = 0; gc.gridy = 0;
		c.add(customersPanel, gc);
		System.out.println("Added Panels");
		
		gc.gridx = 0; gc.gridy = 1; gc.weighty = 5;
		c.add(testPanell, gc);
	}
}

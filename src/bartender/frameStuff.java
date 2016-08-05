package bartender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frameStuff extends JFrame {
	
	JPanel customersPanel;
	Container c;
	GridBagConstraints gc;
	
	
	public frameStuff(String title, Main d){
		super(title);
		setSize(1000, 800);
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
	}
}

package bartender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomersPanel extends JPanel{
	
	
	GridBagConstraints gc;
	
	public CustomersPanel(){
		setPreferredSize(new Dimension(600, 150));
		setSize(600, 150);
		setBackground(Color.RED);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.gridwidth = 1;
		gc.gridheight = 1;
		System.out.println("CustomersPanel initialization");
		
		//Initialize Panels
		gc.gridx=0;
		gc.gridy=0;
		
		
		gc.gridx = 0; gc.gridy = 1;
		//add(customer1, gc);
		gc.gridx = 1; gc.gridy = 1;
		//add(customer2, gc);
		gc.gridx = 2;
		//add(customer3, gc);
		gc.gridx = 3;
		//add(customer4, gc);
		gc.gridx = 3;
		//add(customer5, gc);
	}
}

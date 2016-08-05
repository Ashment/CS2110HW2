package bartender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomersPanel extends JPanel{
	
	GridBagConstraints gc;
	JLabel c1Label;
	
	ImageIcon happy;
	
	CustomerClass c1, c2, c3, c4, c5;
	
	public CustomersPanel(){
		setPreferredSize(new Dimension(600, 150));
		//setSize(600, 150);
		setBackground(Color.RED);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.gridwidth = 1;
		gc.gridheight = 1;
		System.out.println("CustomersPanel initialization");
		
		happy = new ImageIcon("OccHappy.png");
		c1 = new CustomerClass("Customer1", happy, happy, happy, happy);
		c2 = new CustomerClass("Customer2", happy, happy, happy, happy);
		c3 = new CustomerClass("Customer3", happy, happy, happy, happy);
		c4 = new CustomerClass("Customer4", happy, happy, happy, happy);
		c5 = new CustomerClass("Customer5", happy, happy, happy, happy);
		
		//Initialize Panels
		gc.gridx=0;
		gc.gridy=0;
		
		gc.gridx = 0; gc.gridy = 0;
		gc.insets = new Insets(5, 5, 5, 5);
		add(c1.customerIcon, gc);
		gc.gridy = 1;
		add(c1.customerLabel, gc);
		
		gc.gridx = 1; gc.gridy = 0;
		add(c2.customerIcon, gc);
		gc.gridy = 1;
		add(c2.customerLabel, gc);
		
		gc.gridx = 2; gc.gridy = 0;
		add(c3.customerIcon, gc);
		gc.gridy = 1;
		add(c3.customerLabel, gc);
		
		gc.gridx = 3; gc.gridy = 0;
		add(c4.customerIcon, gc);
		gc.gridy = 1;
		add(c4.customerLabel, gc);
		
		gc.gridx = 4; gc.gridy = 0;
		add(c5.customerIcon, gc);
		gc.gridy = 1;
		add(c5.customerLabel, gc);
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = CustomersPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

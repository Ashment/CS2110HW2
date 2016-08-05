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
	
	CustomerClass c1;
	
	public CustomersPanel(){
		setPreferredSize(new Dimension(600, 150));
		setSize(600, 150);
		setBackground(Color.RED);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.gridwidth = 1;
		gc.gridheight = 1;
		System.out.println("CustomersPanel initialization");
		
		happy = createImageIcon("/images/OccHappy.png", "happyIcon");
		c1 = new CustomerClass("Customer1", happy);
		
		//Initialize Panels
		gc.gridx=0;
		gc.gridy=0;
		
		gc.gridx = 0; gc.gridy = 1;
		add(c1, gc);
		gc.gridx = 1; gc.gridy = 1;
		//add(customer2, gc);
		gc.gridx = 2;
		//add(customer3, gc);
		gc.gridx = 3;
		//add(customer4, gc);
		gc.gridx = 3;
		//add(customer5, gc);
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

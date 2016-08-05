package bartender;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerClass extends JLabel{
	static ImageIcon happy;
	static ImageIcon sad;
	static ImageIcon neutral;
	static ImageIcon empty;
	
	JLabel customerIcon, customerLabel, customerRequest;
	
	public CustomerClass(String name, ImageIcon hap, ImageIcon neut, ImageIcon sd, ImageIcon emp){
		happy = hap; neutral = neut; sd = sad; empty = emp;
		customerIcon = new JLabel(hap);
		customerLabel = new JLabel(name);
		customerRequest = new JLabel("Long Island");
	}
}

package bartender;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerClass extends JLabel{
	static ImageIcon happy;
	static ImageIcon sad;
	static ImageIcon neutral;
	static ImageIcon empty;
	public String order;
	
	JLabel customerIcon, customerLabel, customerRequest;
	
	public CustomerClass(String drinkWanted, ImageIcon hap, ImageIcon neut, ImageIcon sd, ImageIcon emp){
		happy = hap; neutral = neut; sad = sd; empty = emp;
		order = drinkWanted;
		customerIcon = new JLabel(hap);
		customerLabel = new JLabel(drinkWanted);
		customerRequest = new JLabel("Long Island");
		
		customerIcon.setIcon(happy);
	}
}

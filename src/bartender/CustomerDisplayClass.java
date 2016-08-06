package bartender;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerDisplayClass extends JLabel{
	static ImageIcon happy;
	static ImageIcon sad;
	static ImageIcon neutral;
	static ImageIcon empty;
	public String order;
	
	JLabel customerIcon, customerLabel, customerRequest;
	
	public CustomerDisplayClass(String drinkWanted, ImageIcon hap, ImageIcon neut, ImageIcon sd, ImageIcon emp){
		happy = hap; neutral = neut; sad = sd; empty = emp;
		order = drinkWanted;
		customerIcon = new JLabel(hap);
		customerLabel = new JLabel(drinkWanted);
		
		customerIcon.setIcon(happy);
	}
	
	public void SetIcon(int state){
		//0=empty, 1=happy, 2=neutral, 3=sad
		switch(state){
			case 0:
				customerIcon.setIcon(empty);
				break;
			case 1:
				customerIcon.setIcon(happy);
				break;
			case 2:
				customerIcon.setIcon(neutral);
				break;
			case 3:
				customerIcon.setIcon(sad);
				break;
			default:
				customerIcon.setIcon(empty);
				break;
		}
	}
	
	public void SetString(String str){
		customerLabel.setText(str);
	}
}

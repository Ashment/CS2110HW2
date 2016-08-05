package bartender;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerClass extends JLabel{
	static ImageIcon happy;
	ImageIcon sad;
	ImageIcon neutral;
	ImageIcon empty;
	
	public CustomerClass(String name, ImageIcon img){
		super(name, happy, JLabel.CENTER);
	}
}

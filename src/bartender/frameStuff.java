package bartender;

import javax.swing.JFrame;

public class frameStuff extends JFrame {
	public frameStuff(String title, Main d){
		super(title);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		addKeyListener(new KeyInput(d));
	}
}

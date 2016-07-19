package hw3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static MainGUI mainGUI;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mainGUI = new MainGUI("Title");
				mainGUI.setSize(550, 350);
				mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainGUI.setVisible(true);
			}
		});
	}

}

package hw3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static MainGUI mainGUI;
	public static Main mainThis;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}
	
	public Main(){
		mainThis = this;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mainGUI = new MainGUI("Title", mainThis);
				mainGUI.setSize(550, 450);
				mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainGUI.setVisible(true);
			}
		});
	}

}

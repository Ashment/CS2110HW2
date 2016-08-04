package bartender;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main{
	
	JFrame debugFrame;
	
	public Main(){
		new DrinksAndIngredients();
		debugFrame = new frameStuff("TITLE", this);
	}
	
	public static void main(String[] args) throws Exception{
		new Main();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println("Key Released: " + key);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		System.out.println("Key Pressed: " + key);
	}
}

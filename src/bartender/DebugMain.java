package bartender;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class DebugMain extends JPanel{
	
	public DebugMain(){
		setSize(500, 500);
		addKeyListener(new KeyInput(this));
		new DrinksAndIngredients();
	}
	
	public static void main(String[] args) throws Exception{
		new DebugMain();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println(key);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		System.out.println(key);
	}
}

package bartender;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	Game m;
	
	public KeyInput(Game main){
		m = main;
	}
	
	public void keyPressed(KeyEvent e){
		m.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		m.keyReleased(e);
	}
}

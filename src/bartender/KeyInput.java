package bartender;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	DebugMain m;
	
	public KeyInput(DebugMain main){
		m = main;
	}
	
	public void keyPressed(KeyEvent e){
		m.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		m.keyReleased(e);
	}
}

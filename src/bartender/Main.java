package bartender;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main{
	
	static Main thisMain;
	Game game;
	Graphics2D g;
	
	BufferedImage occHSprite = null;
	
	public Main(){
		new DrinksAndIngredients();
	    javax.swing.SwingUtilities.invokeLater(new Runnable(){
	        public void run(){
	          game = new Game("BARTENDING LAIFU", thisMain, "Game Thread");
	          game.start();
	        }
	    });
	    
		try {
		    occHSprite = ImageIO.read(new File("occHappy.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		thisMain = new Main();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		//game.keyReleased(e.getKeyCode());
		System.out.println("Key Released: " + key);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		System.out.println("Key Pressed: " + key);
	}
}

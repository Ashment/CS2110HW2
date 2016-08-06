package bartender;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable{
	
	Thread thread;
	String threadName;
	
	JPanel customersPanel;
	IngredientsPanel ingredientsPanel;
	Container c;
	GridBagConstraints gc;
	
	
	public Game(String title, Main d, String tName){
		super(title);
		threadName = tName;
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(new KeyInput(d));
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		
		customersPanel = new CustomersPanel();
		ingredientsPanel = new IngredientsPanel();
		
		c = getContentPane();
		
		gc.gridx = 0; gc.gridy = 0;
		c.add(customersPanel, gc);
		gc.gridx = 0; gc.gridy = 1;
		c.add(ingredientsPanel, gc);
		System.out.println("Added Panels");
		
		InitiateCustomerLists();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			//System.out.println("game run");
		}
	}
	
	public void start(){
		System.out.println("Starting Game Frame");
		
		if(thread == null){
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
	
	public void InitiateCustomerLists(){
		((CustomersPanel) customersPanel).CreateLists();
	}
}

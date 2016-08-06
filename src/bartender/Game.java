package bartender;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable{
	
	Thread thread;
	String threadName;
	
	CustomersPanel customersPanel;
	IngredientsPanel ingredientsPanel;
	BartendingPanel bartendingPanel;
	Container c;
	GridBagConstraints gc;
	
	String currentIngredients;
	ImageIcon[] mixerIcons;
	
	public Drink currentDrink;
	
	public Game(String title, Main d, String tName){
		super(title);
		threadName = tName;
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(new KeyInput(this));
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		
		customersPanel = new CustomersPanel(this);
		ingredientsPanel = new IngredientsPanel();
		FindMixerIcons();
		bartendingPanel = new BartendingPanel(mixerIcons[0], DrinksAndIngredients.badDrink.icon);
		
		c = getContentPane();
		
		gc.gridx = 0; gc.gridy = 0;
		c.add(customersPanel, gc);
		gc.gridx = 0; gc.gridy = 1;
		c.add(ingredientsPanel, gc);
		gc.gridx = 1; gc.gridy = 0; gc.gridheight = 2;
		c.add(bartendingPanel, gc);
		System.out.println("Added Panels");
		
		InitiateCustomerLists();
		currentIngredients = "";
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
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println(key);
		char c = (char)e.getKeyCode();
		if(c == "Q".charAt(0) || c == "W".charAt(0) || c == "E".charAt(0) || c == "R".charAt(0) || c == "T".charAt(0) || c == "Y".charAt(0) || c == "U".charAt(0) ||
				c == "A".charAt(0) || c == "S".charAt(0) || c == "D".charAt(0) || c == "F".charAt(0)){
			String str = Character.toString(Character.toUpperCase(c));
			System.out.println("Inputted Ingredient: " + str);
			if(currentIngredients.length() < 4){
				currentIngredients += str;
				System.out.println("Current Ingredients: " + currentIngredients);
				UpdateMixerUI();
			}
		}else if(key == 8){
			//backspace
			KillDrink(true);
		}else if(key == 32){
			//space bar
			if(currentIngredients != ""){
				CreateDrink();
			}
		}else if(c == "1".charAt(0) || c == "2".charAt(0) || c == "3".charAt(0) || c == "4".charAt(0) || c == "5".charAt(0)){
			int cIndex = Character.getNumericValue(c);
			cIndex--;
			ServeCustomer(cIndex);
		}
	}
	
	public void KillDrink(boolean CLEAR){
		if(CLEAR) ResetDrink();
		currentDrink = null;
		bartendingPanel.UpdateDrink(currentDrink);
	}
	
	public void ResetDrink(){
		currentIngredients = "";
		UpdateMixerUI();
	}
	
	public void CreateDrink(){
		currentDrink = DrinksAndIngredients.FindDrink(currentIngredients);
		bartendingPanel.UpdateDrink(currentDrink);
		ResetDrink();
	}
	
	public void UpdateMixerUI(){
		bartendingPanel.SetMixerIcon(mixerIcons[currentIngredients.length()]);
	}
	
	public void FindMixerIcons(){
		mixerIcons = new ImageIcon[5];
		for(int i=0; i<mixerIcons.length; i++){
			String name = "fill";
			name += i;
			name += ".png";
			ImageIcon c = new ImageIcon(name);
			mixerIcons[i] = c;
		}
	}
	
	public void ServeCustomer(int index){
		customersPanel.Serve(index, currentDrink);
	}
}

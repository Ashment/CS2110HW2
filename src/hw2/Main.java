package hw2;

import javax.swing.JFrame;

public class Main {
	static Main main;
	public Faction protoss, zerg, terran;
	public WorldMarket market;
	public JFrame frame;
	public MainUI ui;
	
	public int cycleCount;
	
	public static void main(String[] args){
		main = new Main();
	}
	public Main(){
		//Initialize Factions and set references
		protoss = new Faction("Protoss", 100, 8, "Alloy", this);
		zerg = new Faction("Zerg", 80, 12, "Biofuel", this);
		terran = new Faction("Terran", 60, 4, "Stim", this);
		
		//debug print for faction initialization
		System.out.println(protoss.toString());
		System.out.println(zerg.toString());
		System.out.println(terran.toString());
		
		//Initialize World Market
		market = new WorldMarket(this);
		System.out.println(market.main.cycleCount);
		cycleCount = 0;
		
		//Initialize UI
		frame = new MainUI("Economy Simulation", this);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		ui = (MainUI)frame;
	}
	
	public void StartNewCycle(){
		cycleCount++;
		ui.AddMessage("\nSimulating Market Cycle: " + cycleCount + "\n----------\n");
		market.NewCycle();
	}
	
	public int NumberRandom(int min, int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}

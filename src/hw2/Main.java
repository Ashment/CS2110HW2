package hw2;

public class Main {
	static Main main;
	public static Faction protoss, zerg, terran;
	Faction[] factions;
	
	public static void main(String[] args){
		main = new Main();
	}
	public Main(){
		//Initialize Factions and set references
		protoss = new Faction("Protoss", 100, 8, "Alloy", this);
		zerg = new Faction("Zerg", 80, 12, "Biofuel", this);
		terran = new Faction("Terran", 60, 6, "Stim", this);
		factions = new Faction[3];
		factions[0] = protoss;
		factions[1] = zerg;
		factions[2] = terran;
		
		//debug print for faction initialization
		System.out.println(protoss.toString());
		System.out.println(zerg.toString());
		System.out.println(terran.toString());
		
		//Initialize World Market
	}
	public int NumberRandom(int min, int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}

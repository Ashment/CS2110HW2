package hw2;

public class Main {
	static Main main;
	public static Faction protoss, zerg, terran;
	
	public static void main(String[] args){
		main = new Main();
	}
	public Main(){
		//Initialize Factions
		protoss = new Faction("Protoss", 100, "Alloy");
		zerg = new Faction("Zerg", 80, "Biofuel");
		terran = new Faction("Terran", 50, "Stim");
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

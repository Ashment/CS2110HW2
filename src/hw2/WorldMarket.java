package hw2;
import hw2.resources.*;

public class WorldMarket {
	
	Resource worldBiofuel, worldAlloy, worldStim;
	int basePrcB = 120, basePrcA = 100, basePrcS = 200;
	
	public WorldMarket(){
		worldBiofuel = new Biofuel();
		worldAlloy = new Alloy();
		worldStim = new Stim();
		
		worldBiofuel.setPrice(basePrcB);
		worldAlloy.setPrice(basePrcA);
		worldStim.setPrice(basePrcS);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

package hw2;
import hw2.resources.*;

public class WorldMarket {
	
	Resource worldBiofuel, worldAlloy, worldStim;
	int basePrcB = 60, basePrcA = 50, basePrcS = 100;
	Trader PTrader, ZTrader, TTrader;
	Main main;
	
	public WorldMarket(Main m){
		main = m;
		
		worldBiofuel = new Biofuel();
		worldAlloy = new Alloy();
		worldStim = new Stim();
		
		worldBiofuel.setPrice(basePrcB);
		worldAlloy.setPrice(basePrcA);
		worldStim.setPrice(basePrcS);
		
		PTrader = main.terran;
		ZTrader = main.zerg;
		TTrader = main.terran;
	}
	
	public void NewCycle(){
		//Initialize Cycle
		main.zerg.ProduceResources();
		main.zerg.DetermineCycleConsumption();
		main.protoss.ProduceResources();
		main.protoss.DetermineCycleConsumption();
		main.terran.ProduceResources();
		main.terran.DetermineCycleConsumption();
		
		//Transactions
		ResourceTransaction(PTrader, ZTrader, "Biofuel");
		ResourceTransaction(PTrader, TTrader, "Stim");
		ResourceTransaction(ZTrader, PTrader, "Alloy");
		ResourceTransaction(ZTrader, TTrader, "Stim");
		ResourceTransaction(TTrader, ZTrader, "Biofuel");
		ResourceTransaction(TTrader, PTrader, "Alloy");
		System.out.println("Transactions Complete.");
		
		//Finalize
	}
	
	public void ResourceTransaction(Trader buyer, Trader seller, String tradedResource){
		int buyerDemand;
		
		if(buyer.getDemandOf(tradedResource) > seller.getSupplyOf(tradedResource)){
			buyer.setDemand(tradedResource, seller.getSupplyOf(tradedResource));
		}
		
		//Resource Transaction
		seller.changeSupplyOf(tradedResource, buyer.getDemandOf(tradedResource));
		//Buyer Consumes Resource!
		
		//Capital Transaction
		if(tradedResource == "Biofuel"){
			seller.changeCapital(worldBiofuel.getPrice() * buyer.getDemandOf(tradedResource));
			buyer.changeCapital(-worldBiofuel.getPrice() * buyer.getDemandOf(tradedResource));
		}else if(tradedResource == "Alloy"){
			seller.changeCapital(worldAlloy.getPrice() * buyer.getDemandOf(tradedResource));
			buyer.changeCapital(-worldAlloy.getPrice() * buyer.getDemandOf(tradedResource));
		}else if(tradedResource == "Stim"){
			seller.changeCapital(worldStim.getPrice() * buyer.getDemandOf(tradedResource));
			buyer.changeCapital(-worldStim.getPrice() * buyer.getDemandOf(tradedResource));
		}else{
			System.out.println("Invalid traded resource");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

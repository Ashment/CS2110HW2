package hw2;
import hw2.resources.*;

public class WorldMarket {
	
	Resource worldBiofuel, worldAlloy, worldStim;
	int basePrcB = 60, basePrcA = 40, basePrcS = 110;
	Trader PTrader, ZTrader, TTrader;
	Main main;
	
	String cycleString = new String();
	
	public WorldMarket(Main m){
		main = m;
		
		worldBiofuel = new Biofuel();
		worldAlloy = new Alloy();
		worldStim = new Stim();
		
		worldBiofuel.setPrice(basePrcB);
		worldAlloy.setPrice(basePrcA);
		worldStim.setPrice(basePrcS);
		
		PTrader = main.protoss;
		ZTrader = main.zerg;
		TTrader = main.terran;
	}
	
	public void NewCycle(){
		System.out.println("Start Cycle");
		//Initialize Cycle
		main.zerg.ProduceResources();
		main.zerg.DetermineCycleConsumption();
		main.protoss.ProduceResources();
		main.protoss.DetermineCycleConsumption();
		main.terran.ProduceResources();
		main.terran.DetermineCycleConsumption();
		
		//Transactions
		System.out.println("Start Transactions");
		ResourceTransaction(PTrader, ZTrader, "Biofuel");
		ResourceTransaction(PTrader, TTrader, "Stim");
		ResourceTransaction(ZTrader, PTrader, "Alloy");
		ResourceTransaction(ZTrader, TTrader, "Stim");
		ResourceTransaction(TTrader, ZTrader, "Biofuel");
		ResourceTransaction(TTrader, PTrader, "Alloy");
		System.out.println("Transactions Complete.");
		
		//Finalize
		System.out.println("Finalize Cycle");
		cycleString += "\n Zerg capital: " + main.zerg.capital;
		cycleString += "\n Protoss capital: " + main.protoss.capital;
		cycleString += "\n Terran capital: " + main.terran.capital;
		cycleString += "\n \n Cycle Completed. \n";
		
		main.ui.AddMessage(cycleString);
		cycleString = new String();
	}
	
	public void ResourceTransaction(Trader buyer, Trader seller, String tradedResource){
		int totalPrice;
		
		if(buyer.getDemandOf(tradedResource) > seller.getSupplyOf(tradedResource)){
			buyer.setDemand(tradedResource, seller.getSupplyOf(tradedResource));
			cycleString += buyer.toString() + " Demand adjusted. \n \n";
		}
		
		//Resource Transaction
		seller.changeSupplyOf(tradedResource, buyer.getDemandOf(tradedResource));
		//Buyer Consumes Resource!
		
		//Capital Transaction
		if(tradedResource == "Biofuel"){
			seller.changeCapital(worldBiofuel.getPrice() * buyer.getDemandOf(tradedResource));
			buyer.changeCapital(-worldBiofuel.getPrice() * buyer.getDemandOf(tradedResource));
			totalPrice = worldBiofuel.getPrice() * buyer.getDemandOf(tradedResource);
		}else if(tradedResource == "Alloy"){
			seller.changeCapital(worldAlloy.getPrice() * buyer.getDemandOf(tradedResource));
			buyer.changeCapital(-worldAlloy.getPrice() * buyer.getDemandOf(tradedResource));
			totalPrice = worldAlloy.getPrice() * buyer.getDemandOf(tradedResource);
		}else if(tradedResource == "Stim"){
			seller.changeCapital(worldStim.getPrice() * buyer.getDemandOf(tradedResource));
			buyer.changeCapital(-worldStim.getPrice() * buyer.getDemandOf(tradedResource));
			totalPrice = worldStim.getPrice() * buyer.getDemandOf(tradedResource);
		}else{
			System.out.println("Invalid traded resource");
			return;
		}
		
		cycleString += buyer.toString() + " has purchased " + buyer.getDemandOf(tradedResource) + " units of " + tradedResource + " from " + seller.toString() + " for " + totalPrice + " Capital. \n";                             
		
	}
}

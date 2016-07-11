package hw2;

import hw2.resources.*;

public class Faction implements Trader{
	public int capital;
	public String name;
	public String specialty;
	
	public Main main;
	
	Resource biofuel, alloy, stim, special;
	
	public int biofuelProductionPower, alloyProductionPower, stimProductionPower, specialProductionPower, productionDeviation;
	//public int cBiofuelDemand, cAlloyDemand, cStimDemand;
	
	public Faction(String n, int production, int productDeviation, String specialR, Main m) {
		capital = 2500;
		name = n;
		//create faction-specific resource data when faction is created
		biofuel = new Biofuel();
		alloy = new Alloy();
		stim = new Stim();
		specialty = specialR;
		
		productionDeviation = productDeviation;
		//Factions produce only its special resource
		switch (specialR){
			case "Alloy":
				alloy.SetDemand(0);
				alloyProductionPower = production;
				specialProductionPower = alloyProductionPower;
				special = alloy;
				biofuelProductionPower = 0;
				stimProductionPower = 0;
				break;
			case "Biofuel":
				biofuel.SetDemand(0);
				biofuelProductionPower = production;
				specialProductionPower = biofuelProductionPower;
				special = biofuel;
				stimProductionPower = 0;
				alloyProductionPower = 0;
				break;
			case "Stim":
				stim.SetDemand(0);
				stimProductionPower = production;
				specialProductionPower = stimProductionPower;
				special = stim;
				alloyProductionPower = 0;
				biofuelProductionPower = 0;
				break;
			default:
				break;
		}
	}
	
	public String toString(){
		String s = "Factions: " + name + "\n"
				+ "Producing " + specialty + " at: " + specialProductionPower + "/cycle \n";
		return s;
	}
	
	public int getSupplyOf(String r){
		int x = 0;
		
		//get supply depending on special resource (this method may or may not be actually useless)
		switch(r){
			case "Alloy":
				x = alloy.GetSupply();
				break;
			case "Biofuel":
				x = biofuel.GetSupply();
				break;
			case "Stim":
				x = stim.GetSupply();
				break;
			default:
				x = 0;
				break;
		}
		
		return x;
	}
	
	public void ProduceResources(){
		
	}
	
	public void DetermineCycleConsumption(){
		//Determine the amount of each resources to consume in this cycle
		int i = 0; //desired consumption of resource
		
		//Alloy consumption/demand
		if(special != alloy){
			//set cAlloyDemand
			i = main.NumberRandom(27, 39); //max consumption 117
			alloy.SetDemand(i);
		}else{
			int supply = special.GetSupply();
			i = main.NumberRandom(27, 39); //max consumption 117
			supply -= i;
			special.SetSupply(supply);
		}
		
		//Biofuel consumption/demand
		if(special != biofuel){
			//set cBiofuelDemand
			i = main.NumberRandom(21, 31); //max consumption 93
			biofuel.SetDemand(i);
		}else{
			int supply = special.GetSupply();
			i = main.NumberRandom(21, 31); //max consumption 93
			supply -= i;
			special.SetSupply(supply);
		}
		
		//stim consumption/demand
		if(special != stim){
			//set cStimDemand
			i = main.NumberRandom(16, 25); //max consumption 75
			stim.SetDemand(i);
		}else{
			int supply = special.GetSupply();
			i = main.NumberRandom(16, 25); //max consumption 75
			supply -= i;
			special.SetSupply(supply);
		}
	}
}

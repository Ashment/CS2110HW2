package hw2;

import hw2.resources.*;

public class Faction implements Trader{
	public int capital;
	public String name;
	public String specialty;
	
	public Main main;
	
	Resource biofuel, alloy, stim, special;
	
	public int biofuelProductionPower, alloyProductionPower, stimProductionPower, specialProductionPower;
	public int cBiofuelDemand, cAlloyDemand, cStimDemand;
	
	public Faction(String n, int production, String specialR, Main m) {
		name = n;
		//create faction-specific resource data when faction is created
		biofuel = new Biofuel();
		alloy = new Alloy();
		stim = new Stim();
		specialty = specialR;
		
		//Produce only its special resource
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
}

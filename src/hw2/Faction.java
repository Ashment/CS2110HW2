package hw2;

import hw2.resources.*;

public class Faction {

	public int capital;
	public String name;
	public String specialty;
	
	Resource biofuel, alloy, stim;
	
	public int biofuelProductionPower, alloyProductionPower, stimProductionPower, specialProductionPower;
	
	public Faction(String n, int production, String specialR) {
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
				biofuelProductionPower = 0;
				stimProductionPower = 0;
				break;
			case "Biofuel":
				biofuel.SetDemand(0);
				biofuelProductionPower = production;
				specialProductionPower = biofuelProductionPower;
				stimProductionPower = 0;
				alloyProductionPower = 0;
				break;
			case "Stim":
				stim.SetDemand(0);
				stimProductionPower = production;
				specialProductionPower = stimProductionPower;
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
}

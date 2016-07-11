package hw2;

import hw2.resources.*;

public class Faction {

	public int capital;
	public String name;
	public String specialty;
	
	Resource biofuel, alloy, stim;
	
	public int biofuelProductionPower, alloyProductionPower, stimProductionPower;
	
	public Faction(String n, int production, String specialR) {
		name = n;
		biofuel = new Biofuel();
		alloy = new Alloy();
		stim = new Stim();
		specialty = specialR;
		
		switch (specialR){
			case "Alloy":
				alloy.SetDemand(0);
				alloyProductionPower = production;
				biofuelProductionPower = 0;
				stimProductionPower = 0;
				break;
			case "Biofuel":
				biofuel.SetDemand(0);
				biofuelProductionPower = production;
				stimProductionPower = 0;
				alloyProductionPower = 0;
				break;
			case "Stim":
				stim.SetDemand(0);
				stimProductionPower = production;
				alloyProductionPower = 0;
				biofuelProductionPower = 0;
				break;
			default:
				break;
		}
	}
}

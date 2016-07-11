package hw2.resources;

public class Resource {
	int supply, demand;
	static int worldSupply, worldDemand;
	private static int maxValue, minValue;
	public static String name;
	
	public void SetDemand(int d){
		demand = d;
	}
	public void SetSupply(int s){
		supply = s;
	}
}
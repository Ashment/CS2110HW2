package hw2.resources;

public class Resource {
	int supply, demand;
	static int worldSupply, worldDemand;
	private static int value;
	public static String name;
	
	public void SetDemand(int d){
		demand = d;
	}
	public void SetSupply(int s){
		supply = s;
	}
	public void setPrice(int p){
		value = p;
	}
}
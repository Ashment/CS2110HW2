package hw2.resources;

public class Resource {
	int supply, demand;
	static int worldSupply, worldDemand;
	private static int value;
	public static String name;
	
	public void SetDemand(int d){
		demand = d;
	}
	public int GetDemand(){
		return demand;
	}
	public void SetSupply(int s){
		supply = s;
	}
	public int GetSupply(){
		return supply;
	}
	public void setPrice(int p){
		value = p;
	}
}
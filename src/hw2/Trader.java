package hw2;

public interface Trader {
	int getSupplyOf(String r); //for getting supply
	int getDemandOf(String r); //for getting demand
	void changeSupplyOf(String r, int c); //adjust supply
	void changeCapital(int c); //adjust capital
	void setDemand(String r, int n); //set demand
}
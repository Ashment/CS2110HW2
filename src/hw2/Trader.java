package hw2;

public interface Trader {
	int getSupplyOf(String r);
	int getDemandOf(String r);
	void changeSupplyOf(String r, int c);
	void changeCapital(int c);
}
package bartender;

public class Customer {
	//Customer Class for Customer Queue
	public Drink wantedDrink;
	
	public int patience;
	public int cPatience;
	
	public Customer(Drink dr){
		wantedDrink = dr;
		
		patience = CustomerList.NumberRandom(48, 64);
		cPatience = patience;
	}
}

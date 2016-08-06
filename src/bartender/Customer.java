package bartender;

public class Customer {
	public Drink wantedDrink;
	
	public int patience;
	public int cPatience;
	
	public Customer(Drink dr){
		wantedDrink = dr;
		
		patience = CustomerList.NumberRandom(24, 38);
		cPatience = patience;
	}
}
